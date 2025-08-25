package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos

sealed interface LargeVideosAction {
    data class ToggleSelection(val videoId: String) : LargeVideosAction
    object DeleteSelected : LargeVideosAction
}
