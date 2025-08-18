package com.hjcoding.kmpcleaner.feature.feature_tool.presentation.toolbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ToolboxScreenRoot(
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
    viewModel: ToolboxViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ToolboxScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun ToolboxScreen(
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
    state: ToolboxState,
    onAction: (ToolboxAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Unspecified),
        containerColor = Color.Unspecified,
        topBar = {

        }) { paddingValues ->
    }
}

@Preview
@Composable
fun ToolboxScreenPreview() {
    ToolboxScreenRoot()
}