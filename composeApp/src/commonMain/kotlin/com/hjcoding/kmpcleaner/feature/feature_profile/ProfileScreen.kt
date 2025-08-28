package com.hjcoding.kmpcleaner.feature.feature_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomBar
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreenRoot(
    currentDestination: NavDestination? = null,
    onClickBottomItem: ((BottomNavItem) -> Unit)? = null,
    viewModel: ProfileViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProfileScreen(
        state = state,
        onAction = viewModel::onAction,
        currentDestination = currentDestination,
        onClickBottomItem = onClickBottomItem
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    state: ProfileState,
    onAction: (ProfileAction) -> Unit,
    currentDestination: NavDestination? = null,
    onClickBottomItem: ((BottomNavItem) -> Unit)? = null
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("我的", fontWeight = FontWeight.Bold) })
        },
        bottomBar = {
            BottomBar(
                currentDestination = currentDestination,
                onClickBottomItem = onClickBottomItem
            )
        },
        containerColor = Color(0xFFF3F4F6)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            SubscriptionCard()
            OtherSection(state.profileItems)
        }
    }
}

@Composable
fun SubscriptionCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFDE047), Color(0xFFFBBF24))
                )
            )
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("订阅 PRO 会员", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.ExtraBold)
                Text("一键解锁全部功能", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* TODO */ }) {
                    Text("立刻体验")
                }
            }
        }
    }
}

@Composable
fun OtherSection(items: List<ProfileItem>) {
    print("items $items")
    Column {
        Text("其他", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
        Card(shape = RoundedCornerShape(16.dp)) {
            Column {
                items.forEachIndexed { index, item ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(item.icon, contentDescription = null, modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(item.name, modifier = Modifier.weight(1f))
                        if (item.value != null) {
                            Text(item.value, color = Color.Gray)
                        } else {
                            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Gray)
                        }
                    }
                    if (index < items.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = DividerDefaults.Thickness,
                            color = DividerDefaults.color
                        )
                    }
                }
            }
        }
    }
}
