package com.hjcoding.kmpstarter.feature.feature_auth.data

import com.hjcoding.kmpstarter.core.domain.DataError
import com.hjcoding.kmpstarter.core.domain.Result
import com.hjcoding.kmpstarter.core.network.api.WebApi
import com.hjcoding.kmpstarter.core.network.safeCall
import com.hjcoding.kmpstarter.feature.feature_auth.data.remote.response.ConfigValueDto
import com.hjcoding.kmpstarter.feature.feature_auth.data.remote.response.TokenDto
import com.hjcoding.kmpstarter.feature.feature_auth.domain.AuthDataSource
import com.hjcoding.kmpstarter.feature.feature_auth.domain.LoginType
import com.hjcoding.kmpstarter.feature.feature_auth.domain.getOsType
import com.hjcoding.kmpstarter.platform.Platform
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthDataSourceImpl(val client : HttpClient) : AuthDataSource, KoinComponent {

    val platform : Platform by inject()

    override suspend fun getConfigValue(name: String): Result<ConfigValueDto, DataError.Remote> {
        return safeCall {
            client.get(WebApi.CONFIG) {
                url {
                    parameters.append("name", name)
                }
            }
        }
    }

    override suspend fun guestLogin(): Result<TokenDto, DataError.Remote> {
        return safeCall {
            client.get(WebApi.LOGIN) {
                url {
                    parameters.append("type", LoginType.LOGIN_WITH_GUEST.ordinal.toString())
                    parameters.append("deviceId", platform.uniqueId)
                    parameters.append("os", getOsType(platform).ordinal.toString())
                }
            }
        }
    }

    override suspend fun refreshToken(refreshToken : String): Result<TokenDto, DataError.Remote> {
        TODO("Not yet implemented")
    }
}