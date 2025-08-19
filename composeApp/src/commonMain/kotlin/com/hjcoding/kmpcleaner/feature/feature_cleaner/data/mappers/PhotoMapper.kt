package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.mappers

import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.PhotoEntity
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo

fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        id = id,
        creationDate = creationDate,
        width = width,
        height = height,
        sizeInBytes = sizeInBytes)
}