package com.hjcoding.kmpstarter.feature.feature_auth.presentation.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hjcoding.kmpstarter.Greeting
import com.hjcoding.kmpstarter.core.designsystem.theme.LocalThemeIsDark
import kmpstarter.composeapp.generated.resources.Res
import kmpstarter.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreenRoot(viewModel: SplashViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val isConnected by viewModel.isConnected.collectAsStateWithLifecycle()

   SplashScreen(
        isConnected = isConnected,
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun SplashScreen(
    isConnected : Boolean,
    state: SplashState,
    onAction: (SplashAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Unspecified),
        containerColor = Color.Unspecified,
        topBar = {

        }) { paddingValues ->

        var showContent by remember { mutableStateOf(false) }
        var isDark by LocalThemeIsDark.current
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent
                isDark = !isDark}) {
                Text("Click me!")
            }

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: ${greeting.greet()}")
                }
            }
        }
    }
}