package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video


interface MediaRespository {

    suspend fun getStorageUsage(): StorageUsage

    suspend fun getAllPhotos(): List<Photo>

    suspend fun getScreenshotPhotos(): List<Photo>

    suspend fun getNonScreenshotPhotos(): List<Photo>

    suspend fun getAllVideos(): List<Video>
}