package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video

data class LargeVideosUiState(
    val isLoading: Boolean = true,
    val videos: List<Video> = emptyList(),
    val selectedVideos: Set<String> = emptySet(),
    val error: String? = null
)
