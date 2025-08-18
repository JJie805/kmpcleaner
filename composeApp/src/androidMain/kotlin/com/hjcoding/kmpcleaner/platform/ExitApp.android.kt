package com.hjcoding.kmpcleaner.platform

import com.hjcoding.kmpcleaner.util.ActivityProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual fun exitApp() {
    ExitAppImpl.exit()
}

private object ExitAppImpl : KoinComponent {
    private val activityProvider: ActivityProvider by inject()

    fun exit() {
        activityProvider.currentActivity()?.finishAffinity()
//        Process.killProcess(Process.myPid())
    }
}