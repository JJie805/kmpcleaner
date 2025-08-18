package com.hjcoding.kmpcleaner.platform

interface Platform {
    val name: String
    val systemVersion : String
    val appVersionName : String
    val appVersionCode : String
    val uniqueId : String
}