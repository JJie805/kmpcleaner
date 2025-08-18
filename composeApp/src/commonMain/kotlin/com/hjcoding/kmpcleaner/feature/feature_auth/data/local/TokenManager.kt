package com.hjcoding.kmpcleaner.feature.feature_auth.data.local

import com.hjcoding.kmpcleaner.core.data.local.preferences.UserPreferences
import com.hjcoding.kmpcleaner.core.domain.getOrNull
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.model.Token
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.repository.AuthRespository
import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TokenManager(
    private val userPreferences: UserPreferences,
) : KoinComponent {
    // 延迟注入，不会在构造时立刻拿到 AuthRespository
    private val authRepository: AuthRespository by inject()

    // 获取 token 的 suspend 版本（建议包装成 suspend，而不是 Flow）
    suspend fun getAccessToken(): String? {
        return userPreferences.getAccessToken.firstOrNull()
    }

    suspend fun getRefreshToken(): String? {
        return userPreferences.getRefreshToken.firstOrNull()
    }

    suspend fun saveTokens(accessToken: String? = null,
                           refreshToken: String? = null) {
        accessToken?.let {
            userPreferences.saveAccessToken(it)
        }
        refreshToken?.let {
            userPreferences.saveRefreshToken(it)
        }
    }

    suspend fun clearTokens() {
        userPreferences.clearTokens()
    }

    suspend fun guestToken(): Token? {
        return authRepository.guestLogin().getOrNull()
    }
}

