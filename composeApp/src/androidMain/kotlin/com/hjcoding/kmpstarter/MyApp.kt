package com.hjcoding.kmpstarter

import android.app.Application
import com.hjcoding.kmpstarter.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApp)
            androidLogger()
        }

    }
}