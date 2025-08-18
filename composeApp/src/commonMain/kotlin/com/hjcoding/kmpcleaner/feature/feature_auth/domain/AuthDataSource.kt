package com.hjcoding.kmpcleaner.feature.feature_auth.domain
import com.hjcoding.kmpcleaner.feature.feature_auth.data.remote.response.TokenDto
import com.hjcoding.kmpcleaner.core.domain.DataError
import com.hjcoding.kmpcleaner.core.domain.Result
import com.hjcoding.kmpcleaner.feature.feature_auth.data.remote.response.ConfigValueDto
import com.hjcoding.kmpcleaner.platform.Platform

enum class LoginType{
    UNSPECIFIED, //未设置
    LOGIN_WITH_GUEST, //临时登陆
    LOGIN_WITH_PHONE, //短信验证码登陆
    LOGIN_WITH_WE_CHAT, //微信登陆
    LOGIN_WITH_ONE_KEY, //一键登陆
    LOGIN_WITH_APPLE //苹果登陆
}

enum class OsType {
    ANDROID,
    IOS,
    UNKNOW
}

fun getOsType(platform: Platform) : OsType{
    return when {
        platform.name.contains("Android") -> OsType.ANDROID
        platform.name.contains("Ios") -> OsType.IOS
        else -> OsType.UNKNOW
    }

}

interface AuthDataSource {

    /*---------------------------配置相关---------------------------*/
    suspend fun getConfigValue(name: String): Result<ConfigValueDto, DataError.Remote>

    suspend fun guestLogin() : Result<TokenDto, DataError.Remote>

    suspend fun refreshToken(refreshToken : String) : Result<TokenDto, DataError.Remote>
}