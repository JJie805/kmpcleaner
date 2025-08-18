package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.mappers

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model.PhotoUi

fun Photo.toPhotoUi(): PhotoUi {
    return PhotoUi(
        id = id,
        thumbnail = thumbnail,
        hashThumbnail = hashThumbnail,
        creationDate = creationDate,
        width = width,
        height = height,
        isSelected = false)
}