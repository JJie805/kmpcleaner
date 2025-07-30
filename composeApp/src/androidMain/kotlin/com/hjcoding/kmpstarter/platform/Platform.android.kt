package com.hjcoding.kmpstarter.platform

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import com.hjcoding.kmpstarter.util.DeviceUtils

class AndroidPlatform(context: Context) : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val systemVersion: String = Build.VERSION.SDK_INT.toString()
    override val appVersionName: String = try {
        val packageInfo: PackageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName ?: "Unknown"
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }
    override val appVersionCode: String = try {
        val packageInfo: PackageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            packageInfo.longVersionCode.toString()
        } else {
            packageInfo.versionCode.toString()
        }
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }
    override val uniqueId: String = DeviceUtils.getUniquePseudoID()
}