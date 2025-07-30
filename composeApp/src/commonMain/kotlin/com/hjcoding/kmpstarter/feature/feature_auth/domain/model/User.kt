package com.hjcoding.kmpstarter.feature.feature_auth.domain.model

data class User(
    val account : String,
    val password : String,
    val accessToken : String
)
