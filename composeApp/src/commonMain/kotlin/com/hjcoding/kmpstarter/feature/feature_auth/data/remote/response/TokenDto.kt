package com.hjcoding.kmpstarter.feature.feature_auth.data.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDto(
    @SerialName("token")
    val accessToken : String,
    @SerialName("refreshToken")
    val refreshToken : String? = null
)

@Serializable
data class LogoutDto(
    val token : String
)
