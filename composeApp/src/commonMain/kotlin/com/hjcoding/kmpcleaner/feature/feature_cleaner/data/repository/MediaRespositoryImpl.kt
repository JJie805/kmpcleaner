package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.repository

import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.mappers.toPhoto
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.mappers.toStorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.mappers.toVideo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.DeviceStorageSource
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.StorageUsage
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.platform.MediaScanner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext

class MediaRespositoryImpl(val mediaScanner : MediaScanner,
                           private val deviceStorageSource: DeviceStorageSource
) : MediaRespository {

    override suspend fun getStorageUsage(): StorageUsage {
        return deviceStorageSource.getStorageDetails().toStorageUsage()
    }

    override suspend fun getAllPhotos(): List<Photo> {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.getAllPhotos { photoEntitys ->
                    continuation.resume(photoEntitys.map { it.toPhoto() }) { cause, _, _ -> }
                }
            }
        }
    }



    override suspend fun getScreenshotPhotos(): List<Photo> {

        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.getScreenshotPhotos { photoEntitys ->
                    continuation.resume(photoEntitys.map { it.toPhoto() }) { cause, _, _ -> }
                }
            }
        }
    }

    override suspend fun getNonScreenshotPhotos(): List<Photo> {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.getNonScreenshotPhotos { photoEntitys ->
                    continuation.resume(photoEntitys.map { it.toPhoto() }) { cause, _, _ -> }
                }
            }
        }
    }

    override suspend fun getAllVideos(): List<Video>{
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine {continuation ->
                mediaScanner.getAllVideos{videoEntitys->
                    continuation.resume(videoEntitys.map { it.toVideo() }) { cause, _, _ ->  }
                }
            }
        }
    }
}