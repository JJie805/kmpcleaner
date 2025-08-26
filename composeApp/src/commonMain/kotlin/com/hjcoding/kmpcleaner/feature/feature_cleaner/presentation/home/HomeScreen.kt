package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomBar
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.StorageInfo
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoot(
    currentDestination: NavDestination? = null,
    onClickBottomItem: ((BottomNavItem) -> Unit)? = null,
    onClickCleanupItem: (CleanupType) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onAction = viewModel::onAction,
        currentDestination = currentDestination,
        onClickBottomItem = onClickBottomItem,
        onClickCleanupItem = onClickCleanupItem
    )
}

@Composable
fun HomeScreen(
    currentDestination: NavDestination? = null,
    onClickBottomItem: ((BottomNavItem) -> Unit)? = null,
    state: HomeState,
    onAction: (HomeAction) -> Unit,
    onClickCleanupItem: (CleanupType) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF3F4F6), // Light gray background
        bottomBar = {
            BottomBar(
                currentDestination = currentDestination,
                onClickBottomItem = onClickBottomItem
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            val mainItems = state.cleanupItems.filter { it.displayType != DisplayType.GRID }
            val gridItems = state.cleanupItems.filter { it.displayType == DisplayType.GRID }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { HomeHeader() }
                item { StorageOverview(state.storageInfo) }

                items(mainItems.size) { index ->
                    val item = mainItems[index]
                    when (item.displayType) {
                        DisplayType.FULL_WIDTH_WITH_THUMBNAILS -> CleanupThumbnailItem(item, onClick = { onClickCleanupItem(item.type) })
                        DisplayType.SIMPLE_ROW -> CleanupSimpleItem(item, onClick = { onClickCleanupItem(item.type) })
                        else -> {}
                    }
                }

                if (gridItems.isNotEmpty()) {
                    item { CleanupGridSection(gridItems, onClickCleanupItem) }
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            if (state.error != null) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = state.error, color = MaterialTheme.colorScheme.error)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { onAction(HomeAction.Refresh) }) {
                        Text("重试")
                    }
                }
            }
        }
    }
}

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("火箭清理王", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
        Button(onClick = { /* TODO: Handle Pro click */ }) {
            Text("PRO")
        }
    }
}

@Composable
fun StorageOverview(storageInfo: StorageInfo) {
    // This can be further customized to match the picture exactly
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("存储空间", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { storageInfo.progress },
                modifier = Modifier.fillMaxWidth().height(8.dp).clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(storageInfo.usageDescription, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

// For items with thumbnails like 'Similar Photos'
@Composable
fun CleanupThumbnailItem(item: CleanupItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(item.icon, contentDescription = null, modifier = Modifier.size(40.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(item.title, fontWeight = FontWeight.Bold)
                    Text("${item.itemCount} 张图片，可释放 ${item.sizeInBytes / 1024 / 1024}MB", fontSize = 12.sp, color = Color.Gray)
                }
                Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, tint = Color.Gray)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                item.thumbnails.forEach {
                    Image(
                        bitmap = it,
                        contentDescription = null,
                        modifier = Modifier.weight(1f).aspectRatio(1f).clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

// For items without content like 'Large Videos'
@Composable
fun CleanupSimpleItem(item: CleanupItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(item.icon, contentDescription = null, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(item.title, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.Green, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("手机相册干净，未发现${item.title}", fontSize = 12.sp, color = Color.Gray)
                }
            }
            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, tint = Color.Gray)
        }
    }
}

// For grid items like 'Contacts', 'Calendar'
@Composable
fun CleanupGridSection(items: List<CleanupItem>, onClickCleanupItem: (CleanupType) -> Unit) {
    Column {
        Text("其他清理", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(bottom = 8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.height(240.dp) // Adjust height as needed
        ) {
            items(items.size) { index ->
                val item = items[index]
                GridItem(item, onClick = { onClickCleanupItem(item.type) })
            }
        }
    }
}

@Composable
fun GridItem(item: CleanupItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(item.icon, contentDescription = null, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(item.title, fontWeight = FontWeight.Bold)
            Text("${item.itemCount} 项", fontSize = 12.sp, color = Color.Gray)
        }
    }
}