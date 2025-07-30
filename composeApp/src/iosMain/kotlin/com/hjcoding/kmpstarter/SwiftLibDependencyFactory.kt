package com.hjcoding.kmpstarter

import com.hjcoding.kmpstarter.platform.Analytics
import com.hjcoding.kmpstarter.platform.Platform
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

interface SwiftLibDependencyFactory {
    fun provideFirebaseAnalyticsImpl(): Analytics
    fun providePlatformImpl(): Platform
}

internal fun swiftLibDependenciesModule(factory: SwiftLibDependencyFactory): Module = module {
    single { factory.provideFirebaseAnalyticsImpl() } bind Analytics::class
    single { factory.providePlatformImpl() } bind Platform::class
}

fun KoinApplication.provideSwiftLibDependencyFactory(factory: SwiftLibDependencyFactory) =
    run { modules(swiftLibDependenciesModule(factory)) }