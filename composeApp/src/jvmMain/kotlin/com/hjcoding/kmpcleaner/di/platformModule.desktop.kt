package com.hjcoding.kmpcleaner.di

import com.hjcoding.kmpcleaner.core.data.util.ConnectivityObserver
import com.hjcoding.kmpcleaner.util.DesktopConnectivityObserver
import com.hjcoding.kmpcleaner.datastore.createDesktopDataStore
import com.hjcoding.kmpcleaner.platform.DesktopPlatform
import com.hjcoding.kmpcleaner.platform.Platform
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { DesktopPlatform() } bind Platform::class
    single { createDesktopDataStore() }
    single { DesktopConnectivityObserver()} bind ConnectivityObserver::class
}