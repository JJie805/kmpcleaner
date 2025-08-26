package com.hjcoding.kmpcleaner.feature.feature_toolbox

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomBar
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ToolboxScreenRoot(
    currentDestination: NavDestination? = null,
    onClickBottomItem: ((BottomNavItem) -> Unit)? = null,
    viewModel: ToolboxViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    ToolboxScreen(
        state = state,
        onAction = viewModel::onAction,
        currentDestination = currentDestination,
        onClickBottomItem = onClickBottomItem
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolboxScreen(
    state: ToolboxState,
    onAction: (ToolboxAction) -> Unit,
    currentDestination: NavDestination? = null,
    onClickBottomItem: ((BottomNavItem) -> Unit)? = null
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("工具箱", fontWeight = FontWeight.Bold) })
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
            MyPhoneSection(state.gaugeItems)
            ToolsSection(state.toolItems)
        }
    }
}

@Composable
fun MyPhoneSection(items: List<GaugeInfo>) {
    Column {
        Text("我的手机", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items.forEach {
                    GaugeItem(it)
                }
            }
        }
    }
}

@Composable
fun GaugeItem(info: GaugeInfo) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(80.dp)) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawArc(
                    color = Color.LightGray,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = Color.Blue, // Color can be dynamic based on value
                    startAngle = -90f,
                    sweepAngle = 360 * (info.value / 100f),
                    useCenter = false,
                    style = Stroke(width = 8.dp.toPx(), cap = StrokeCap.Round)
                )
            }
            Text("${info.value}%", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(info.label, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
fun ToolsSection(items: List<ToolItem>) {
    Column {
        Text("工具", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(items.size) { index ->
                val item = items[index]
                Card(
                    modifier = Modifier.width(150.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(item.icon, contentDescription = null, modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(item.name, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}