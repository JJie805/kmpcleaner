package com.hjcoding.kmpstarter.core.designsystem.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Start
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hjcoding.kmpstarter.Route

@Composable
fun BottomBar(
    navController: NavController,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Mine,
    )
) {

    Row(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.navigationBars)
            .height(30.67.dp),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            val selected =
                currentDestination?.route?.contains(item.route.toString()) == true
            val color = if (selected) Color(0xFF027FFF) else Color(0xFF666666)
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
                    .selectable(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(BottomNavItem.Home.route) {
                                    saveState = true // 用于页面状态的恢复
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        enabled = true,
                        role = Role.Tab,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    )
                    .weight(1f),
            ) {
                Icon(
                    modifier = Modifier.size(12.67.dp),
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = color
                )

                Text(
                    text = item.label,
                    color = color,
                    textAlign = TextAlign.Center,
                    fontSize = 7.12.sp,
                    lineHeight = 7.12.sp
                )
            }
        }
    }
}



sealed class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: Any
) {
    data object Home : BottomNavItem(
        label = "home",
        icon = Icons.Rounded.Home,
        route = Route.Home
    )

    data object Mine : BottomNavItem(
        label = "mine",
        icon = Icons.Rounded.Start,
        route = Route.Mine
    )
}
