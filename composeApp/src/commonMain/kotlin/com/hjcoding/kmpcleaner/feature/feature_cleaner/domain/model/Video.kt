package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model

data class Video(
    override val id: String,
    val creationDate: Long,
    val duration: Long,
    val sizeInBytes: Long,
) : Media