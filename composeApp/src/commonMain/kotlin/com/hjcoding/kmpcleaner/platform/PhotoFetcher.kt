package com.hjcoding.kmpcleaner.platform

import coil3.ImageLoader
import coil3.decode.DataSource
import coil3.decode.ImageSource
import coil3.fetch.FetchResult
import coil3.fetch.Fetcher
import coil3.fetch.SourceFetchResult
import coil3.request.Options
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Media
import okio.Buffer
import okio.FileSystem

expect suspend fun getMediaThumbnailData(media: Media): ByteArray?

class MediaFetcher(private val media: Media) : Fetcher {
    override suspend fun fetch(): FetchResult? {
        val data = getMediaThumbnailData(media) ?: return null
        val source = ImageSource(source = Buffer().write(data), fileSystem = FileSystem.SYSTEM)
        return SourceFetchResult(
            source = source,
            mimeType = "image/jpeg",
            dataSource = DataSource.DISK
        )
    }
}

class MediaFetcherFactory : Fetcher.Factory<Media> {
    override fun create(data: Media, options: Options, imageLoader: ImageLoader): Fetcher? {
        return MediaFetcher(data)
    }
}
