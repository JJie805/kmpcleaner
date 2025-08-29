package com.hjcoding.kmpcleaner.platform

import android.content.ContentUris
import android.provider.MediaStore
import coil3.ImageLoader
import coil3.decode.DataSource
import coil3.decode.ImageSource
import coil3.fetch.FetchResult
import coil3.fetch.Fetcher
import coil3.fetch.SourceResult
import coil3.request.Options
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import okio.source

actual class PhotoFetcherFactory : Fetcher.Factory<Photo> {
    override fun create(data: Photo, options: Options, imageLoader: ImageLoader): Fetcher {
        return object : Fetcher {
            override suspend fun fetch(): FetchResult {
                val photoUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    data.id.toLong()
                )
                val inputStream = options.androidContext.contentResolver.openInputStream(photoUri)!!
                return SourceResult(
                    source = ImageSource(
                        source = inputStream.source(),
                        fileSystem = options.fileSystem
                    ),
                    mimeType = "image/*",
                    dataSource = DataSource.DISK
                )
            }
        }
    }
}
