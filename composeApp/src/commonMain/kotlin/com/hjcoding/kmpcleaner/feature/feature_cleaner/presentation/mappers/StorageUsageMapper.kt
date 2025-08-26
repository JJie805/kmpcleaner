package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.mappers

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.StorageInfo
import kotlin.math.roundToInt

fun StorageUsage.toStorageInfo(): StorageInfo {
    val progress = if (totalBytes > 0) usedBytes.toFloat() / totalBytes.toFloat() else 0f
    val usedSpaceFormatted = formatBytes(usedBytes)
    val totalSpaceFormatted = formatBytes(totalBytes)

    return StorageInfo(
        usedSpaceFormatted = usedSpaceFormatted,
        totalSpaceFormatted = totalSpaceFormatted,
        usageDescription = "已使用${totalSpaceFormatted}中的${usedSpaceFormatted}",
        progress = progress
    )
}

private fun formatBytes(bytes: Long): String {
    if (bytes < 1024) return "$bytes B"
    val kb = bytes / 1024.0
    if (kb < 1024) return "${(kb * 10).roundToInt() / 10.0} KB"
    val mb = kb / 1024.0
    if (mb < 1024) return "${(mb * 10).roundToInt() / 10.0} MB"
    val gb = mb / 1024.0
    return "${(gb * 10).roundToInt() / 10.0} GB"
}
