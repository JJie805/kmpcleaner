package com.hjcoding.kmpcleaner.platform

import androidx.compose.ui.graphics.ImageBitmap
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.PhotoEntity
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.VideoEntity


interface MediaScanner {

    fun getAllPhotos(completion: (List<PhotoEntity>) -> Unit)
    fun getScreenshotPhotos(completion: (List<PhotoEntity>) -> Unit)
    fun getNonScreenshotPhotos(completion: (List<PhotoEntity>) -> Unit)
    fun getAllVideos(completion: (List<VideoEntity>) -> Unit)

    // 【新增】按需获取位图的新方法
    fun getThumbnailBitmap(forId: String, isVideo: Boolean, completion: (ImageBitmap?) -> Unit)

    fun getAhashBitmap(forId: String, completion: (ImageBitmap?) -> Unit)

    fun getDhashBitmap(forId: String, completion: (ImageBitmap?) -> Unit)

}