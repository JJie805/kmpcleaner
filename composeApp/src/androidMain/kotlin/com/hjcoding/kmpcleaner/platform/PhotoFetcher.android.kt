package com.hjcoding.kmpcleaner.platform

import coil3.ImageLoader
import coil3.decode.DataSource
import coil3.fetch.Fetcher
import coil3.fetch.SourceFetchResult
import coil3.request.Options
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import okio.Buffer

// 这是之前 PhotoFetcher 的逻辑，现在包装在 actual class 中
//actual class PhotoFetcherFactory(
//    private val mediaRepository: MediaRespository
//) : Fetcher.Factory<Photo> {
//    override fun create(data: Photo, options: Options, imageLoader: ImageLoader): Fetcher {
//        // 返回一个匿名的 Fetcher 实例
//        return object : Fetcher {
//            override suspend fun fetch() = mediaRepository
//                .getThumbnailBitmap(data.id, isVideo = false)
//                ?.let { imageBitmap -> imageBitmapToByteArray(imageBitmap) }
//                ?.let { byteArray ->
//                    SourceFetchResult(
//                        source = Buffer().write(byteArray),
//                        mimeType = "image/png",
//                        dataSource = DataSource.DISK
//                    )
//                }
//        }
//    }
//}