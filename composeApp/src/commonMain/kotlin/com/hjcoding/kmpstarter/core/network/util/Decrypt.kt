package com.hjcoding.kmpstarter.core.network.util

import okio.internal.commonToUtf8String
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

object Decrypt {
    @OptIn(ExperimentalEncodingApi::class)
    fun decrypt(str : String) : String{
        val result = Base64.decode(str).commonToUtf8String()
        val substring = result.substring(0, 5)
        val substring1 = result.substring(6, 11);
        val substring2 = result.substring(12, result.length - 6);
        val substring3 = result.substring(result.length - 5);
        val s = substring + substring1 + substring2 + substring3;
        return Base64.decode(s).commonToUtf8String()
    }
}