package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo

data class ScreenshotsUiState(
    val isLoading: Boolean = true,
    val screenshots: List<Photo> = emptyList(),
    val selectedScreenshots: Set<String> = emptySet(),
    val error: String? = null
)
