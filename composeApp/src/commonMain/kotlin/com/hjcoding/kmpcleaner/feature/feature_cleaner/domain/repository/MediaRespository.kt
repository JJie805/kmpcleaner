package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository

import androidx.compose.ui.graphics.ImageBitmap
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video


interface MediaRespository {

    suspend fun getStorageUsage(): StorageUsage

    suspend fun getAllPhotos(): List<Photo>

    suspend fun getScreenshotPhotos(): List<Photo>

    suspend fun getNonScreenshotPhotos(): List<Photo>

    suspend fun getAllVideos(): List<Video>


    suspend fun getThumbnailBitmap(id: String, isVideo: Boolean): ImageBitmap?
    suspend fun getAhashBitmap(id: String): ImageBitmap?

    suspend fun getDhashBitmap(id: String): ImageBitmap?

    suspend fun deletePhotos(ids: List<String>): Result<Unit>

    suspend fun deleteVideos(ids: List<String>): Result<Unit>
}