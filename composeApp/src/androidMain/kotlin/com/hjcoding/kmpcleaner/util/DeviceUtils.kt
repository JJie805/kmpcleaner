package com.hjcoding.kmpcleaner.util

import android.os.Build
import java.util.UUID

object DeviceUtils {
    fun getUniquePseudoID(): String {
        // 拼接硬件信息得到一串15位数字（这里"35"加上后面的13位，共15位）
        val mSzDevIDShort = "35" +
                (Build.BOARD.length % 10).toString() +
                (Build.BRAND.length % 10).toString() +
                (Build.CPU_ABI.length % 10).toString() +
                (Build.DEVICE.length % 10).toString() +
                (Build.DISPLAY.length % 10).toString() +
                (Build.HOST.length % 10).toString() +
                (Build.ID.length % 10).toString() +
                (Build.MANUFACTURER.length % 10).toString() +
                (Build.MODEL.length % 10).toString() +
                (Build.PRODUCT.length % 10).toString() +
                (Build.TAGS.length % 10).toString() +
                (Build.TYPE.length % 10).toString() +
                (Build.USER.length % 10).toString()

        // 尝试获取序列号（API>=9）
        val serial: String = try {
            Build::class.java.getField("SERIAL").get(null)?.toString() ?: "serial"
        } catch (e: Exception) {
            "serial" // 获取失败时使用默认值
        }


        // 使用 UUID 类根据硬件信息和序列号生成伪唯一ID
        return UUID(mSzDevIDShort.hashCode().toLong(), serial.hashCode().toLong()).toString()
    }
}