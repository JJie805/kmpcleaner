package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarscreenshots

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.SimilarPhotoGroup

data class SimilarScreenshotsUiState(
    val isLoading: Boolean = true,
    val photoGroups: List<SimilarPhotoGroup> = emptyList(),
    val selectedPhotos: Set<String> = emptySet(),
    val error: String? = null
)
