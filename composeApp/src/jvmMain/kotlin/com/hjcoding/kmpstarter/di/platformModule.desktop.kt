package com.hjcoding.kmpstarter.di

import com.hjcoding.kmpstarter.core.data.util.ConnectivityObserver
import com.hjcoding.kmpstarter.util.DesktopConnectivityObserver
import com.hjcoding.kmpstarter.datastore.createDesktopDataStore
import com.hjcoding.kmpstarter.platform.DesktopPlatform
import com.hjcoding.kmpstarter.platform.Platform
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { DesktopPlatform() } bind Platform::class
    single { createDesktopDataStore() }
    single { DesktopConnectivityObserver()} bind ConnectivityObserver::class
}