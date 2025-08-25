package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarscreenshots

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.PhotoGroup

data class SimilarScreenshotsUiState(
    val isLoading: Boolean = true,
    val photoGroups: List<PhotoGroup> = emptyList(),
    val selectedPhotos: Set<String> = emptySet(),
    val error: String? = null
)
