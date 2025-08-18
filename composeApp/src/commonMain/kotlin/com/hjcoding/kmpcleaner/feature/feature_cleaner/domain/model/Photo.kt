package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model

import androidx.compose.ui.graphics.ImageBitmap

data class Photo(
    val id: String,
    val thumbnail: ImageBitmap,
    val hashThumbnail: ImageBitmap,
    val creationDate: Long,
    val width: Int,
    val height: Int,
    val sizeInBytes: Long,
)
