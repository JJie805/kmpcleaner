package com.hjcoding.kmpstarter

import com.hjcoding.kmpstarter.platform.Platform
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Greeting : KoinComponent {
    private val platform: Platform by inject() // 延迟注入

    fun greet() = "Hello, ${platform.name}! appVersionName:${platform.appVersionName} appVersionCode:${platform.appVersionCode} appUniquideId:${platform.uniqueId}"
}