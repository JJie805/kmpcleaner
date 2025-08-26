package com.hjcoding.kmpcleaner

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hjcoding.kmpcleaner.core.data.local.preferences.UserPreferences
import com.hjcoding.kmpcleaner.core.designsystem.components.Background
import com.hjcoding.kmpcleaner.core.designsystem.components.BottomNavItem
import com.hjcoding.kmpcleaner.core.designsystem.theme.AppTheme
import com.hjcoding.kmpcleaner.feature.feature_profile.ProfileScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_auth.presentation.splash.LicenseAgreementDialog
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.calendar.CalendarScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts.ContactsScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.CleanupType
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.HomeScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos.LargeVideosScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots.ScreenshotsScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarphotos.SimilarPhotosScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarscreenshots.SimilarScreenshotsScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarvideos.SimilarVideosScreenRoot
import com.hjcoding.kmpcleaner.feature.feature_tool.presentation.toolbox.ToolboxScreenRoot
import com.hjcoding.kmpcleaner.platform.exitApp
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
                currentDestination = navController.currentDestination,
                onClickBottomItem = { item ->
                    navController.navigate(item.route) {
                        popUpTo(BottomNavItem.Home.route) {
                            saveState = true // 用于页面状态的恢复
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onClickCleanupItem = { cleanupType ->
                    when (cleanupType) {
                        CleanupType.SIMILAR_PHOTOS -> navController.navigate(Route.SimilarPhotosCleanup)
                        CleanupType.LARGE_VIDEOS -> navController.navigate(Route.LargeVideosCleanup)
                        CleanupType.SIMILAR_SCREENSHOTS -> navController.navigate(Route.SimilarScreenshotsCleanup)
                        CleanupType.ALL_SCREENSHOTS -> navController.navigate(Route.ScreenshotsCleanup)
                        CleanupType.SIMILAR_VIDEOS -> navController.navigate(Route.SimilarVideosCleanup)
                        CleanupType.CONTACTS -> navController.navigate(Route.ContactsCleanup)
                        CleanupType.CALENDAR -> navController.navigate(Route.CalendarCleanup)
                        else -> {
                            // Handle other cases if necessary
                        }
                    }
                }
            )
        }

        composable<Route.ToolBox> {
            ToolboxScreenRoot(
                currentDestination = navController.currentDestination,
                onClickBottomItem = { item ->
                    navController.navigate(item.route) {
                        popUpTo(BottomNavItem.Toolbox.route) {
                            saveState = true // 用于页面状态的恢复
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

        composable<Route.User> {
            ProfileScreenRoot(
                currentDestination = navController.currentDestination,
                onClickBottomItem = { item ->
                    navController.navigate(item.route) {
                        popUpTo(BottomNavItem.Home.route) {
                            saveState = true // 用于页面状态的恢复
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

        composable<Route.SimilarPhotosCleanup> { SimilarPhotosScreenRoot() }
        composable<Route.SimilarScreenshotsCleanup> { SimilarScreenshotsScreenRoot() }
        composable<Route.ScreenshotsCleanup> { ScreenshotsScreenRoot() }
        composable<Route.LargeVideosCleanup> { LargeVideosScreenRoot() }
        composable<Route.SimilarVideosCleanup> { SimilarVideosScreenRoot() }
        composable<Route.ContactsCleanup> { ContactsScreenRoot() }
        composable<Route.CalendarCleanup> { CalendarScreenRoot() }
    }
}

