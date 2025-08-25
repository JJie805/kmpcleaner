package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarscreenshots

sealed interface SimilarScreenshotsAction {
    data class ToggleSelection(val photoId: String) : SimilarScreenshotsAction
    object DeleteSelected : SimilarScreenshotsAction
}
