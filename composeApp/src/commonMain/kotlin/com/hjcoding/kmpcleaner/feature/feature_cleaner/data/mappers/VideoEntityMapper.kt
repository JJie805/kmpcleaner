package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.mappers

import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.VideoEntity
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video

fun VideoEntity.toVideo() : Video {
    return Video(
        id = id,
        creationDate = creationDate,
        duration = duration,
        sizeInBytes = sizeInBytes,
    )
}