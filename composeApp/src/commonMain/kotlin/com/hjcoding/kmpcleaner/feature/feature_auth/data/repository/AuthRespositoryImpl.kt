package com.hjcoding.kmpcleaner.feature.feature_auth.data.repository

import com.hjcoding.kmpcleaner.core.domain.DataError
import com.hjcoding.kmpcleaner.core.domain.Result
import com.hjcoding.kmpcleaner.core.domain.map
import com.hjcoding.kmpcleaner.feature.feature_auth.data.remote.response.ConfigValueDto
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.AuthDataSource
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.model.Token
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.repository.AuthRespository

class AuthRespositoryImpl(val authDataSource: AuthDataSource) : AuthRespository {
    override suspend fun getConfigValue(name : String): Result<ConfigValueDto, DataError.Remote> {
        return authDataSource.getConfigValue(name)
    }

    override suspend fun guestLogin(): Result<Token, DataError.Remote> {
        return authDataSource.guestLogin().map { tokenDto ->
            Token(
                accessToken = tokenDto.accessToken,
                refreshToken = tokenDto.refreshToken
            )
        }
    }

    override suspend fun accountPasswordLogin(
        account: String,
        password: String
    ): Result<Token, DataError.Remote> {
        return authDataSource.guestLogin().map { tokenDto ->
            Token(
                accessToken = tokenDto.accessToken,
                refreshToken = tokenDto.refreshToken
            )
        }
    }
}