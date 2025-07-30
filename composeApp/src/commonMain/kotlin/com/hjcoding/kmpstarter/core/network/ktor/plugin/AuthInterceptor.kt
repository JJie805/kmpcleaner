package com.hjcoding.kmpstarter.core.network.ktor.plugin

import com.hjcoding.kmpstarter.core.network.api.WebApi
import com.hjcoding.kmpstarter.feature.feature_auth.data.local.TokenManager
import com.hjcoding.kmpstarter.feature.feature_auth.data.remote.request.LoginType
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.http.encodedPath
import io.ktor.util.AttributeKey

class AuthInterceptor(
    private val tokenManager: TokenManager) : HttpClientPlugin<Unit, AuthInterceptor> {
    override val key = AttributeKey<AuthInterceptor>("AuthInterceptor")

    override fun prepare(block: Unit.() -> Unit) = this

    override fun install(plugin: AuthInterceptor, scope: HttpClient) {
        scope.requestPipeline.intercept(HttpRequestPipeline.Phases.Before) {
            if (context.url.encodedPath.endsWith(WebApi.LOGIN)) {
                val typeParam = context.url.parameters["type"]
                if (typeParam == LoginType.LOGIN_WITH_GUEST.ordinal.toString()) {
                    proceed()
                    return@intercept
                }
            }

            // ✅ 正确挂起调用 suspend 函数
            val token = tokenManager.getAccessToken()
            println("token $token")

            var finalToken = token
            if (finalToken == null) {
                val guestToken = tokenManager.guestToken()?.accessToken
                println("guestToken $guestToken")
                guestToken?.let {
                    tokenManager.saveTokens(accessToken = it)
                    finalToken = it
                }
            }

            println("finalToken $finalToken")
            finalToken?.let { accessToken ->
                context.headers.append("Authorization", "Bearer $accessToken")
            }

            proceed()
        }
    }
}