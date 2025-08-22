package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots

sealed interface ScreenshotsAction {
    data class ToggleSelection(val photoId: String) : ScreenshotsAction
    data object DeleteSelected : ScreenshotsAction
}
