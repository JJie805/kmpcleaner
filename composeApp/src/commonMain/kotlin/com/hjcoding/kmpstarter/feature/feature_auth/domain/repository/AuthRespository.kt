package com.hjcoding.kmpstarter.feature.feature_auth.domain.repository

import com.hjcoding.kmpstarter.core.domain.DataError
import com.hjcoding.kmpstarter.core.domain.Result
import com.hjcoding.kmpstarter.feature.feature_auth.data.remote.response.ConfigValueDto
import com.hjcoding.kmpstarter.feature.feature_auth.domain.model.Token

interface AuthRespository {
    suspend fun getConfigValue(name : String) : Result<ConfigValueDto, DataError.Remote>

    suspend fun guestLogin() : Result<Token, DataError.Remote>

    suspend fun accountPasswordLogin(account : String, password : String) : Result<Token, DataError.Remote>
}