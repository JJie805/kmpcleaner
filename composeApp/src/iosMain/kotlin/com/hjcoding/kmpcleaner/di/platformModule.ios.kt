package com.hjcoding.kmpcleaner.di

import coil3.PlatformContext // 确保导入正确的 PlatformContext
import com.hjcoding.kmpcleaner.core.data.util.ConnectivityObserver
import com.hjcoding.kmpcleaner.util.IosConnectivityObserver
import com.hjcoding.kmpcleaner.database.getDatabaseBuilder
import com.hjcoding.kmpcleaner.datastore.createIosDataStore
import com.hjcoding.kmpcleaner.platform.PhotoFetcherFactory
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

// 这个模块现在是最终的、正确的版本
internal actual val platformModule: Module = module {
    single { MediaFetcherFactory() }
    single { getDatabaseBuilder() }
    single { createIosDataStore() }
    single { IosConnectivityObserver() } bind ConnectivityObserver::class

    // 【最终、正确的解决方案】
    // 我们不再尝试创建任何东西。
    // 我们只是告诉 Koin：当有任何地方需要一个 PlatformContext 时，
    // 请直接提供 Coil 已经为我们准备好的那个单例 INSTANCE。
    single<PlatformContext> {
        PlatformContext.INSTANCE
    }
}  }
}