package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local

data class PhotoEntity(
    val id: String,
    val creationDate: Long,
    val sizeInBytes: Long,
    val width: Int,
    val height: Int,
)

data class VideoEntity(
    val id: String,
    val creationDate: Long,
    val sizeInBytes: Long,
    val duration: Long
)