package com.hjcoding.kmpstarter.feature.feature_auth.presentation.mine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.hjcoding.kmpstarter.core.designsystem.components.BottomBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MineScreenRoot(
    navController : NavController,
    viewModel: MineViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MineScreen(
        state = state,
        onAction = viewModel::onAction,
        navController = navController
    )
}

@Composable
fun MineScreen(
    state: MineState,
    onAction: (MineAction) -> Unit,
    navController : NavController,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Unspecified),
        containerColor = Color.Unspecified,
        bottomBar = {
            BottomBar(navController = navController)
        }) { paddingValues ->
    }
}