package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model

import androidx.compose.ui.graphics.ImageBitmap

data class Video(
    val id: String,
    val thumbnail: ImageBitmap,
    val creationDate: Long,
    val duration: Long // 视频特有的属性（毫秒
)