package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.model

import androidx.compose.ui.graphics.ImageBitmap

data class PhotoUi(
    val id: String,
    val thumbnail: ImageBitmap?,
    val hashThumbnail: ImageBitmap?,
    val creationDate: Long,
    val width: Int,
    val height: Int,
    val isSelected: Boolean
)