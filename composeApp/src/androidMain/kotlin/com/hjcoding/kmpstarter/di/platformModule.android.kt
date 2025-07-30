package com.hjcoding.kmpstarter.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.hjcoding.kmpstarter.core.data.util.ConnectivityObserver
import com.hjcoding.kmpstarter.database.getDatabaseBuilder
import com.hjcoding.kmpstarter.datastore.createAndroidDataStore
import com.hjcoding.kmpstarter.platform.Analytics
import com.hjcoding.kmpstarter.platform.AndroidPlatform
import com.hjcoding.kmpstarter.platform.FirebaseAnalyticsImpl
import com.hjcoding.kmpstarter.platform.Platform
import com.hjcoding.kmpstarter.util.ActivityProvider
import com.hjcoding.kmpstarter.util.AndroidConnectivityObserver
import com.hjcoding.kmpstarter.util.RealActivityProvider
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { FirebaseAnalyticsImpl(firebaseAnalytics = FirebaseAnalytics.getInstance(this.get())) } bind Analytics::class
    single { AndroidPlatform(this.get()) } bind Platform::class
    single { getDatabaseBuilder(this.get()) }
    single { createAndroidDataStore(this.get())}
    single { AndroidConnectivityObserver(this.get())} bind ConnectivityObserver::class
    //createdAtStart = true这样 Koin 在执行完 startKoin { ... modules(platformModule) } 后，马上就去构造,
    // 否则koin默认是懒加载的，会错过registerActivityLifecycleCallbacks时机
    single<ActivityProvider>(createdAtStart = true) { RealActivityProvider(get()) } bind ActivityProvider::class
}