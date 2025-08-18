package com.hjcoding.kmpcleaner

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.DeviceStorageSource
import com.hjcoding.kmpcleaner.platform.Analytics
import com.hjcoding.kmpcleaner.platform.MediaScanner
import com.hjcoding.kmpcleaner.platform.Platform
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

interface SwiftLibDependencyFactory {
    fun provideFirebaseAnalyticsImpl(): Analytics
    fun providePlatformImpl(): Platform
    fun provideMediaScannerImpl(): MediaScanner
    fun provideDeviceStorageSourceImpl(): DeviceStorageSource
}

internal fun swiftLibDependenciesModule(factory: SwiftLibDependencyFactory): Module = module {
    single { factory.provideFirebaseAnalyticsImpl() } bind Analytics::class
    single { factory.providePlatformImpl() } bind Platform::class
    single { factory.provideMediaScannerImpl() } bind MediaScanner::class
    single { factory.provideDeviceStorageSourceImpl() } bind DeviceStorageSource::class
}

fun KoinApplication.provideSwiftLibDependencyFactory(factory: SwiftLibDependencyFactory) =
    run { modules(swiftLibDependenciesModule(factory)) }