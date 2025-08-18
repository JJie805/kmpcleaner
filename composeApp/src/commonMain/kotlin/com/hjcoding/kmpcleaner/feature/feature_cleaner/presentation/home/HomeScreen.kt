package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomBar
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import com.hjcoding.kmpcleaner.core.designsystem.icons.Home
import com.hjcoding.kmpcleaner.core.designsystem.icons.Icons
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.StorageInfo
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun HomeScreenRoot(
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
    viewModel: HomeViewModel = koinViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onAction = viewModel::onAction,
        currentDestination = currentDestination,
        onClickBottomItem = onClickBottomItem
    )
}

@Composable
fun HomeScreen(
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            BottomBar(currentDestination = currentDestination,
                onClickBottomItem = onClickBottomItem)
        }
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            // 使用 LazyColumn 提高性能
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 第一个 item: Header
                item { HomeHeader() }

                // 第二个 item: 存储概览
                item { StorageOverview(state.storageInfo) } // 从 state 获取数据

                // 第三个 item: "推荐清理" 标题
                item {
                    Text(
                        text = "推荐清理",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                // 列表项：清理卡片
                items(state.cleanupItems.size) { index ->
                    val item = state.cleanupItems[index]
                    CleanupItemCard(cleanupItem = item,)
                }
            }

            // 覆盖在 LazyColumn 之上的加载和错误提示
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
fun HomeHeader(){
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = "存储空间清理",
            fontSize = 16.sp)
        Text(text = "释放您的设备空间",
            fontSize = 12.sp)
    }
}

@Composable
fun StorageOverview(storageInfo: StorageInfo){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
        colors = CardDefaults.outlinedCardColors(containerColor = Color.White),
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 2.dp),
        border = CardDefaults.outlinedCardBorder()) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "存储空间",
                fontSize = 16.sp)
            Text(text = "95G",
                fontSize = 12.sp)
            Text(text = "已使用128G中的95G",
                fontSize = 12.sp)
            Spacer(Modifier.height(15.dp))
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                progress = { 30.0f },
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun RingIcon(
    modifier: Modifier = Modifier
        .size(64.dp) // 外圈总大
        .clip(CircleShape)
        .background(Color.Blue,CircleShape)
        .padding(12.dp),
    imageVector: ImageVector,
    tint : Color){
    Box(
        modifier = modifier, // 留出内圈空间
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = tint
        )
    }
}

@Composable
fun CleanupItemCard(cleanupItem : CleanupItem){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
        colors = CardDefaults.outlinedCardColors(containerColor = Color.White),
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 2.dp),
        border = CardDefaults.outlinedCardBorder()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically){

            RingIcon(
                imageVector = cleanupItem.icon,
                tint = cleanupItem.iconColor
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(text = cleanupItem.title)
                Text(text = cleanupItem.describe)
            }

            Spacer(Modifier.weight(1f))

            if (cleanupItem.thumbnails.isNotEmpty()){
                Row(modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Red)
                    .padding(horizontal = 5.dp, vertical = 2.dp)) {
                    Column {
                        Text(text = "9张张片")
                        Text(text = "13.15M")
                    }
                    Icon(
                        imageVector = Icons.Home,
                        contentDescription = null
                    )
                }
            }
        }

        val thumbnails = cleanupItem.thumbnails
        if (thumbnails.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // 无论 1 张还是 2 张，权重都固定为 1f
                thumbnails.forEach { photo ->
                    photo.thumbnail?.let {
                        Image(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(2.0f)
                                .clip(RoundedCornerShape(10.dp)),
                            bitmap = it,
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                }

                // 如果只有 1 张图片，补一个空的 Spacer 占位，使布局宽度一致
                if (thumbnails.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(),
        onAction = {}
    )
}

@Preview
@Composable
fun IconPreview(){
    Box(
        modifier = Modifier
            .size(50.dp) // 外圈总大
            .clip(CircleShape)
            .background(Color.Blue,CircleShape)
            .padding(12.dp), // 留出内圈空间
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Home,
            contentDescription = null,
            tint = Color.Black
        )
    }
}