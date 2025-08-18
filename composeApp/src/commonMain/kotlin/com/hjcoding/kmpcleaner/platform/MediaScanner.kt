package com.hjcoding.kmpcleaner.platform

import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.PhotoEntity
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.VideoEntity


interface MediaScanner {
    fun getAllPhotos(completion: (List<PhotoEntity>) -> Unit)

    fun getScreenshotPhotos(completion: (List<PhotoEntity>) -> Unit)

    fun getNonScreenshotPhotos(completion: (List<PhotoEntity>) -> Unit)

    fun getAllVideos(completion: (List<VideoEntity>) -> Unit)

}