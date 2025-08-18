package com.hjcoding.kmpcleaner.core.network.ktor

import com.hjcoding.kmpcleaner.core.network.ktor.plugin.AuthInterceptor
import com.hjcoding.kmpcleaner.core.network.ktor.plugin.BaseResponsePlugin
import com.hjcoding.kmpcleaner.feature.feature_auth.data.local.TokenManager
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


class HttpClientBuilder(val tokenManager: TokenManager) {
    private val BASE_URL = "https://lmapi.buzhizewen.cn/"

    val client = HttpClient {

        defaultRequest {
            url(BASE_URL)
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true              // 已有：忽略不认识的字段
                isLenient = true                      // ✅ 放宽 JSON 语法（如接受未加引号的 key）
                allowStructuredMapKeys = true         // ✅ 允许 Map 的 key 不是 String（Ktor 有些版本要开）
                coerceInputValues = true              // ✅ 如果类型不匹配，用默认值代替
                useAlternativeNames = true            // ✅ 支持 `@SerialName("xx")` 别名反序列化
                prettyPrint = false                   // ❌ 正式环境建议关掉，调试可设为 true
            })
        }

        install(BaseResponsePlugin) {
            keysForStatus = listOf("code")
            successCode = listOf("200", "0")
            keysForMessage = listOf("msg")
            keysForData = listOf("data")
        }

        install(HttpRequestRetry){
            retryOnException(maxRetries = 1)
        }

        install(AuthInterceptor(tokenManager))
    }
}