package com.hjcoding.kmpstarter.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import java.io.File

// shared/src/desktopMain/kotlin/createDataStore.android.kt
fun createDesktopDataStore(): DataStore<Preferences> = createDataStore(
    producePath = {
        // 1. 取用户家目录
        val home = System.getProperty("user.home")
        // 2. 定义存储目录和文件名（同 Android 端的 dataStoreFileName 保持一致）
        val dir = File(home, ".myapp/datastore").apply {
            if (!exists()) mkdirs()
        }
        // 3. 返回文件绝对路径
        File(dir, dataStoreFileName).absolutePath
    }
)