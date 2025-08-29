package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model

data class Photo(
    override val id: String,
    val creationDate: Long,
    val width: Int,
    val height: Int,
    val sizeInBytes: Long,
) : Media
