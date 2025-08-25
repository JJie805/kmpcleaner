package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarvideos

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.VideoGroup

data class SimilarVideosUiState(
    val isLoading: Boolean = true,
    val videoGroups: List<VideoGroup> = emptyList(),
    val selectedVideos: Set<String> = emptySet(),
    val error: String? = null
)
