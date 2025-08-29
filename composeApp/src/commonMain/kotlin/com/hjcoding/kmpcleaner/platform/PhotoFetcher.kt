package com.hjcoding.kmpcleaner.platform

import coil3.fetch.Fetcher
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo

// 期望每个平台都能提供一个可以处理 Photo 对象的 Fetcher.Factory
expect class PhotoFetcherFactory : Fetcher.Factory<Photo>