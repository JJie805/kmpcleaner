package com.hjcoding.kmpstarter.feature.feature_auth.presentation.home

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
fun HomeScreenRoot(
    navController : NavController,
    viewModel: HomeViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state,
        onAction = viewModel::onAction,
        navController = navController
    )
}

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
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