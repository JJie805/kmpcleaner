package com.hjcoding.kmpstarter

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hjcoding.kmpstarter.core.data.local.preferences.UserPreferences
import com.hjcoding.kmpstarter.core.designsystem.components.Background
import com.hjcoding.kmpstarter.core.designsystem.theme.AppTheme
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.home.HomeScreenRoot
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.login.LoginScreenRoot
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.mine.MineScreen
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.mine.MineScreenRoot
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.splash.LicenseAgreementDialog
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.splash.SplashScreenRoot
import com.hjcoding.kmpstarter.platform.exitApp
import kotlinx.coroutines.launch
import org.koin.compose.getKoin
import org.koin.compose.koinInject

@Composable
fun App(modifier: Modifier = Modifier) {
    val appState = rememberAppState(
        connectivityObserver = getKoin().get()
    )

    val userPreferences: UserPreferences = koinInject()
    val licenseAgreed by userPreferences.licenseAgreementState.collectAsStateWithLifecycle(true)

    Scaffold(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { padding ->
        Background(modifier = modifier) {
            App(appState = appState)
        }
    }

    if (!licenseAgreed) {
        val scope = rememberCoroutineScope()
        val userPreferences: UserPreferences = koinInject()
        LicenseAgreementDialog(
            onDismissRequest = {},
            onAgree = {
                scope.launch {
                    userPreferences.setLicenseAgreement(true)
                }
            },
            onDisagree = {
                scope.launch {
                    userPreferences.setLicenseAgreement(false)
                    exitApp()
                }
            }
        )
    }
}

@Composable
fun App(
    appState: AppState,
    modifier: Modifier = Modifier
) = AppTheme {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {

        composable<Route.Home> {
            HomeScreenRoot(
                navController = navController
            )
        }

        composable<Route.Mine> {
            MineScreenRoot(
                navController = navController
            )
        }

//        composable<Route.Splash> {
//            SplashScreenRoot()
//        }
//
//        composable<Route.Login> {
//            LoginScreenRoot()
//        }
    }
}

