package com.hjcoding.kmpcleaner.di

import com.google.firebase.analytics.FirebaseAnalytics
import com.hjcoding.kmpcleaner.core.data.util.ConnectivityObserver
import com.hjcoding.kmpcleaner.database.getDatabaseBuilder
import com.hjcoding.kmpcleaner.datastore.createAndroidDataStore
import com.hjcoding.kmpcleaner.platform.Analytics
import com.hjcoding.kmpcleaner.platform.AndroidMediaScanner
import com.hjcoding.kmpcleaner.platform.AndroidPlatform
import com.hjcoding.kmpcleaner.platform.FirebaseAnalyticsImpl
import com.hjcoding.kmpcleaner.platform.MediaScanner
import com.hjcoding.kmpcleaner.platform.Platform
import com.hjcoding.kmpcleaner.util.ActivityProvider
import com.hjcoding.kmpcleaner.util.AndroidConnectivityObserver
import com.hjcoding.kmpcleaner.util.RealActivityProvider
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { FirebaseAnalyticsImpl(firebaseAnalytics = FirebaseAnalytics.getInstance(this.get())) } bind Analytics::class
    single { AndroidPlatform(this.get()) } bind Platform::class
    single { getDatabaseBuilder(this.get()) }
    single { createAndroidDataStore(this.get())}
    single { AndroidConnectivityObserver(this.get())} bind ConnectivityObserver::class
    single { AndroidMediaScanner(context = get()) } bind MediaScanner::class
    //createdAtStart = true这样 Koin 在执行完 startKoin { ... modules(platformModule) } 后，马上就去构造,
    // 否则koin默认是懒加载的，会错过registerActivityLifecycleCallbacks时机
    single<ActivityProvider>(createdAtStart = true) { RealActivityProvider(get()) } bind ActivityProvider::class
}