package com.hjcoding.kmpcleaner.feature.feature_auth.presentation.mine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomBar
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserScreenRoot(
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
    viewModel: UserViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UserScreen(
        state = state,
        onAction = viewModel::onAction,
        currentDestination = currentDestination,
        onClickBottomItem = onClickBottomItem
    )
}

@Composable
fun UserScreen(
    state: UserState,
    onAction: (UserAction) -> Unit,
    currentDestination : NavDestination? = null,
    onClickBottomItem : ((BottomNavItem)->Unit)? = null,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Unspecified),
        containerColor = Color.Unspecified,
        bottomBar = {
            BottomBar(currentDestination = currentDestination,
                onClickBottomItem = onClickBottomItem)
        }) { paddingValues ->
    }
}

@Preview
@Composable
fun UserScreenPreview() {
    UserScreenRoot()
}