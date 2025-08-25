package com.hjcoding.kmpcleaner.feature.feature_cleaner.data.repository

import androidx.compose.ui.graphics.ImageBitmap
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

    override suspend fun getThumbnailBitmap(id: String, isVideo: Boolean): ImageBitmap? {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.getThumbnailBitmap(forId = id, isVideo = isVideo) { bitmap ->
                    continuation.resume(bitmap){cause, value, context -> }
                }
            }
        }
    }

    override suspend fun getAhashBitmap(id: String): ImageBitmap? {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.getAhashBitmap(forId = id) { bitmap ->
                    continuation.resume(bitmap){cause, value, context -> }
                }
            }
        }
    }

    override suspend fun getDhashBitmap(id: String): ImageBitmap? {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.getDhashBitmap(forId = id) { bitmap ->
                    continuation.resume(bitmap){cause, value, context -> }
                }
            }
        }
    }

    override suspend fun deletePhotos(ids: List<String>): Result<Unit> {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.deletePhotos(ids) { success ->
                    if (success) {
                        continuation.resume(Result.success(Unit)) { cause, _, _ -> }
                    } else {
                        continuation.resume(Result.failure(Exception("Failed to delete photos"))) { cause, _, _ -> }
                    }
                }
            }
        }
    }

    override suspend fun deleteVideos(ids: List<String>): Result<Unit> {
        return withContext(Dispatchers.IO) {
            suspendCancellableCoroutine { continuation ->
                mediaScanner.deleteVideos(ids) { success ->
                    if (success) {
                        continuation.resume(Result.success(Unit)) { cause, _, _ -> }
                    } else {
                        continuation.resume(Result.failure(Exception("Failed to delete videos"))) { cause, _, _ -> }
                    }
                }
            }
        }
    }
}