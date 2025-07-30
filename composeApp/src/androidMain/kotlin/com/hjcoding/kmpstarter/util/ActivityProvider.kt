package com.hjcoding.kmpstarter.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference

interface ActivityProvider {
    fun currentActivity(): Activity?
}

class RealActivityProvider(app: Application) : ActivityProvider {

    private var currentActivityRef: WeakReference<Activity?> = WeakReference(null)

    init {
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
            override fun onActivityStarted(activity: Activity) {
                currentActivityRef = WeakReference(activity)
            }
            override fun onActivityResumed(activity: Activity) {
                currentActivityRef = WeakReference(activity)
            }
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }

    override fun currentActivity(): Activity? {
        return currentActivityRef.get()
    }
}