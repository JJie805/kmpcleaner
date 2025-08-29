package com.hjcoding.kmpcleaner.di

import com.hjcoding.kmpcleaner.core.data.util.ConnectivityObserver
import com.hjcoding.kmpcleaner.util.IosConnectivityObserver
import com.hjcoding.kmpcleaner.database.getDatabaseBuilder
import com.hjcoding.kmpcleaner.datastore.createIosDataStore
import com.hjcoding.kmpcleaner.platform.PhotoFetcherFactory
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { PhotoFetcherFactory(get()) }
    single { getDatabaseBuilder() }
    single { createIosDataStore() }
    single { IosConnectivityObserver()} bind ConnectivityObserver::class
}


