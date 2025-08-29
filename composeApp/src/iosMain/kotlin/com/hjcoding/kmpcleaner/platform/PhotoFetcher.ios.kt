package com.hjcoding.kmpcleaner.platform // 请确保这是您项目中的实际包名

import coil3.ImageLoader
import coil3.decode.DataSource
import coil3.decode.ImageSource // 正确的导入：这是顶层工厂函数所在的包
import coil3.fetch.FetchResult
import coil3.fetch.Fetcher
import coil3.fetch.SourceFetchResult
import coil3.request.Options
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import okio.Buffer
import okio.FileSystem // 【新导入】我们需要导入 Okio 的 FileSystem

/**
 * 私有的 Fetcher 实现，适用于 Coil 3.1.0
 */
private class IOSPhotoFetcher(
    // options 对象仍然是需要的，即使我们不直接用它的 context
    private val options: Options,
    private val photo: Photo,
    private val mediaRepository: MediaRespository
) : Fetcher {
    override suspend fun fetch(): FetchResult? {
        // 从仓库获取原始的 ByteArray，这部分逻辑不变
        val byteArray = mediaRepository.getThumbnailData(photo.id, isVideo = false)
            ?: return null

        // 【核心修正】调用 ImageSource() 工厂函数，并传入 FileSystem.SYSTEM
        val imageSource = ImageSource(
            source = Buffer().write(byteArray),
            fileSystem = FileSystem.SYSTEM // 使用 Okio 提供的标准系统文件系统实例
        )

        return SourceFetchResult(
            source = imageSource,
            mimeType = "image/jpeg",
            dataSource = DataSource.DISK
        )
    }
}

/**
 * 这是您在 Koin 中注册的、提供给 Coil 的工厂类。
 */
actual class PhotoFetcherFactory(
    private val mediaRepository: MediaRespository
) : Fetcher.Factory<Photo> {
    /**
     * 确保这个函数的签名（尤其是返回类型 Fetcher?）
     * 与您在 commonMain 中定义的 `expect` 函数完全一致。
     */
    override fun create(data: Photo, options: Options, imageLoader: ImageLoader): Fetcher? {
        // 这部分逻辑保持不变，创建并返回 Fetcher 实例
        return IOSPhotoFetcher(
            options = options,
            photo = data,
            mediaRepository = this.mediaRepository
        )
    }
}