package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.PhotoUi
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.StorageInfo

enum class CleanupType {
    SIMILAR_PHOTOS,
    LARGE_VIDEOS,
    SIMILAR_VIDEOS,
    SIMILAR_SCREENSHOTS,
    ALL_SCREENSHOTS,
    CONTACTS,
    CALENDAR
}

data class CleanupItem(
    val type: CleanupType,
    val title: String,
    val describe: String,
    val icon: ImageVector,
    val iconColor: Color,
    val thumbnails: List<PhotoUi>,
    val itemCount: Int = 0, // 新增：项目数量
    val sizeInBytes: Long = 0L // 新增：占用空间
)

data class HomeState(
    val isLoading: Boolean = true,
    val storageInfo: StorageInfo = StorageInfo(),
    val cleanupItems: List<CleanupItem> = emptyList(),
    val error: String? = null
)