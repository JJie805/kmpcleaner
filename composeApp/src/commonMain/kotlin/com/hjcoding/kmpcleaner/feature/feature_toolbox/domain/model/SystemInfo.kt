package com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.model

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.platform.MemoryUsage

data class SystemInfo(
    val cpuUsage: Float,
    val memoryUsage: MemoryUsage,
    val storageUsage: StorageUsage
)