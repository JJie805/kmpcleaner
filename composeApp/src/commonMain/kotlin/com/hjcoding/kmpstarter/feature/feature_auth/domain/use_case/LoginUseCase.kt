package com.hjcoding.kmpstarter.feature.feature_auth.domain.use_case

import com.hjcoding.kmpstarter.core.domain.Result
import com.hjcoding.kmpstarter.core.domain.getOrNull
import com.hjcoding.kmpstarter.feature.feature_auth.data.local.TokenManager
import com.hjcoding.kmpstarter.feature.feature_auth.domain.model.Token
import com.hjcoding.kmpstarter.feature.feature_auth.domain.repository.AuthRespository

class GuestLoginUseCase(private val authRespository: AuthRespository,
                        private val tokenManager: TokenManager) {

    suspend operator fun invoke(): Token? {
        return when (val result = authRespository.guestLogin()) {
            is Result.Success -> {
                tokenManager.saveTokens(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken)
                result.data
            }
            is Result.Error -> {
                null
            }
        }
    }
}

class AccountPasswordLoginUseCase(private val authRespository: AuthRespository) {
    suspend operator fun invoke(account: String, password: String): Token? {
        return authRespository.accountPasswordLogin(account, password).getOrNull()
    }
}
