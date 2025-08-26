package com.hjcoding.kmpcleaner.core.designsystem.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import com.hjcoding.kmpcleaner.core.designsystem.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.Route
import com.hjcoding.kmpcleaner.core.designsystem.icons.Home
import com.hjcoding.kmpcleaner.core.designsystem.icons.Toolbox
import com.hjcoding.kmpcleaner.core.designsystem.icons.User

@Composable
fun BottomBar(
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Toolbox,
        BottomNavItem.Profile,
    )
) {

    Row(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.navigationBars)
            .height(30.67.dp),
    ) {
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
                            onClickBottomItem?.let { it(item) }
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
        icon = Icons.Home,
        route = Route.Home
    )

    data object Toolbox : BottomNavItem(
        label = "toolbox",
        icon = Icons.Toolbox,
        route = Route.ToolBox
    )

    data object Profile : BottomNavItem(
        label = "mine",
        icon = Icons.User,
        route = Route.Profile
    )
}
