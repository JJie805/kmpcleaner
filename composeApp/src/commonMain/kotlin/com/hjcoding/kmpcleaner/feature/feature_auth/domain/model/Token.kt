package com.hjcoding.kmpcleaner.feature.feature_auth.domain.model

data class Token(
    val accessToken : String,
    val refreshToken : String?
)
