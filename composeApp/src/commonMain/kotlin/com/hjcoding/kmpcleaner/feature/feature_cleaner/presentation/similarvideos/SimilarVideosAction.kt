package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarvideos

sealed interface SimilarVideosAction {
    data class ToggleSelection(val videoId: String) : SimilarVideosAction
    object DeleteSelected : SimilarVideosAction
}
