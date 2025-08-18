package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local

import androidx.compose.ui.graphics.ImageBitmap

sealed interface MediaEntity {
    val id: String
    val thumbnail: ImageBitmap
    val creationDate: Long

    val sizeInBytes: Long
}

data class PhotoEntity(
    override val id: String,
    override val thumbnail: ImageBitmap,
    override val creationDate: Long,
    override val sizeInBytes: Long,

    val hashThumbnail: ImageBitmap,
    val width: Int,
    val height: Int,
): MediaEntity

data class VideoEntity(
    override val id: String,
    override val thumbnail: ImageBitmap,
    override val creationDate: Long,
    override val sizeInBytes: Long,

    val duration: Long // 视频特有的属性（毫秒
): MediaEntity