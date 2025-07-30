package com.hjcoding.kmpstarter.platform

import com.hjcoding.kmpstarter.util.ActivityProvider
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