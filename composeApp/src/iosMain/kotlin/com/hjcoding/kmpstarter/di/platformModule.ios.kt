package com.hjcoding.kmpstarter.di

import com.hjcoding.kmpstarter.core.data.util.ConnectivityObserver
import com.hjcoding.kmpstarter.util.IosConnectivityObserver
import com.hjcoding.kmpstarter.database.getDatabaseBuilder
import com.hjcoding.kmpstarter.datastore.createIosDataStore
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { getDatabaseBuilder() }
    single { createIosDataStore() }
    single { IosConnectivityObserver()} bind ConnectivityObserver::class
}


