package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.mappers

import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.StorageDetails
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage

fun StorageDetails.toStorageUsage(): StorageUsage {
    return StorageUsage(
        usedBytes = freeBytes,
        totalBytes = totalBytes
    )
}