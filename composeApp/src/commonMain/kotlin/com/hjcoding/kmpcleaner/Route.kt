package com.hjcoding.kmpcleaner

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Splash

    @Serializable
    data object Login

    @Serializable
    data object Home

    @Serializable
    data object ToolBox
    @Serializable
    data object User

    @Serializable
    data object SimilarPhotosCleanup

    @Serializable
    data object SimilarScreenshotsCleanup

    @Serializable
    data object ScreenshotsCleanup

    @Serializable
    data object LargeVideosCleanup

    @Serializable
    data object SimilarVideosCleanup
}