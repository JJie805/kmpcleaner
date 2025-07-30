package com.hjcoding.kmpstarter.feature.feature_auth.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class ConfigValueDto(
    val id: Int,
    val name : String,
    val value : String,
    val remark : String?
)
