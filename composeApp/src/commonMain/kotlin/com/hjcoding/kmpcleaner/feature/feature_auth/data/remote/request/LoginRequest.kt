package com.hjcoding.kmpcleaner.feature.feature_auth.data.remote.request

import kotlinx.serialization.Serializable
enum class LoginType{
    UNSPECIFIED, //未设置
    LOGIN_WITH_GUEST, //临时登陆
    LOGIN_WITH_PHONE, //短信验证码登陆
    LOGIN_WITH_WE_CHAT, //微信登陆
    LOGIN_WITH_ONE_KEY, //一键登陆
    LOGIN_WITH_APPLE //苹果登陆
}

@Serializable
data class LoginRequest(
    val type:LoginType = LoginType.UNSPECIFIED,
    val deviceId : String?,
    val os :Int?,
    val phoneNumber:String?,
    val phoneCode:String?,
    val channel :Int?,
    val isSetVip:Int?,
    val openCode:String?
)
