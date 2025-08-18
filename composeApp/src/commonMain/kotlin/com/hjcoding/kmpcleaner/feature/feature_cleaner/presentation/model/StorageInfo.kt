package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model

data class StorageInfo(
    val usedSpaceFormatted: String = "0G",
    val totalSpaceFormatted: String = "0G",
    val usageDescription: String = "计算中...",
    val progress: Float = 0.0f
)