package com.hjcoding.kmpcleaner.core.network.ktor.plugin

import com.hjcoding.kmpcleaner.core.network.exception.ExceptionCode
import com.hjcoding.kmpcleaner.core.network.exception.JsonException
import com.hjcoding.kmpcleaner.core.network.util.Decrypt
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.statement.HttpResponseContainer
import io.ktor.client.statement.HttpResponsePipeline
import io.ktor.util.AttributeKey
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.toByteArray
import io.ktor.utils.io.readUTF8Line
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class BaseResponsePlugin(private val config: BaseResponseConfig) {
    class BaseResponseConfig {
        var successCode = listOf("200", "0")
        var keysForStatus = listOf("code")
        var keysForMessage = listOf("msg")
        var keysForData = listOf("data")
    }

    companion object : HttpClientPlugin<BaseResponseConfig, BaseResponsePlugin> {
        override val key: AttributeKey<BaseResponsePlugin>
            get() = AttributeKey("BaseResponsePlugin")

        override fun install(plugin: BaseResponsePlugin, scope: HttpClient) {
            scope.responsePipeline.intercept(HttpResponsePipeline.Receive) {
                val responseConfig = plugin.config
                val response = it.response

                if (response !is ByteReadChannel) return@intercept
                val cryptBodyText = response.readUTF8Line(Int.MAX_VALUE) ?: ""
                val json = Json {
                    ignoreUnknownKeys = true
                }

                val decryptbodyText = Decrypt.decrypt(cryptBodyText.trim('"')) // 去除首尾的 "
                println("decryptbodyText $decryptbodyText")
                //去除转义，有的返回带转移，中文还用unicode编码。。。
                val jsonElement = if (decryptbodyText.startsWith('"')
                    && Json.parseToJsonElement(decryptbodyText) is JsonPrimitive) {
                    val outerJsonElement: JsonElement = Json.parseToJsonElement(decryptbodyText)
                    if (outerJsonElement is JsonPrimitive && outerJsonElement.isString) {
                        // 第一层解析得到的是字符串，内容为内层 JSON 数据
                        val innerJsonString = outerJsonElement.content
                        println("innerJsonString $innerJsonString")

                        // 第二步：解析内层 JSON 字符串
                        Json.parseToJsonElement(innerJsonString)
                    }else{
                        json.parseToJsonElement(decryptbodyText)
                    }
                } else {
                    json.parseToJsonElement(decryptbodyText)
                }
//                println("jsonStr decrypt bodyText: $jsonStr")
//                val jsonElement = json.parseToJsonElement(decryptbodyText)
                if (jsonElement is JsonNull || jsonElement !is JsonObject) {
                    throw JsonException(ExceptionCode.JSON_NULL.toString(), "返回的数据为空")
                }

                val jsonObject = jsonElement.jsonObject
                var status = ""
                for (statusKey in responseConfig.keysForStatus) {
                    val tmp = jsonObject[statusKey]
                    if (tmp != null && tmp !is JsonNull && tmp is JsonPrimitive) {
                        status = tmp.jsonPrimitive.content.trim()
                        break
                    }
                }

                var message = ""
                for (messageKey in responseConfig.keysForMessage) {
                    val tmp = jsonObject[messageKey]
                    if (tmp != null && tmp !is JsonNull && tmp is JsonPrimitive) {
                        message = tmp.jsonPrimitive.content.trim()
                        break
                    }
                }

//                if (status !in responseConfig.successCode) {
//                    throw JsonException(status, message)
//                }


                var dataJson: String? = null
                for (dataKey in responseConfig.keysForData) {
                    val tmp = jsonObject[dataKey]
                    if (tmp != null && tmp !is JsonNull) {
                        dataJson = if (tmp is JsonPrimitive) {
//                            Timber.d("dataJson is JsonPrimitive")
                            tmp.content
                        } else {
//                            Timber.d("dataJson is notJsonPrimitive")
                            json.encodeToString(tmp)
                        }
                        break
                    }
                }

//                if (dataJson == null) {
//                    throw JsonException(ExceptionCode.JSON_DATA_NULL.toString(), "jsonData 为空")
//                }

                val responseContainer = when (dataJson) {
                    null -> {
                        //服务端，返回成功的时候，data会事null。。。。
                        //大概是这样的json{"code":200,"data":null,"msg":"操作成功","success":true}
                        if (jsonObject["success"]?.jsonPrimitive?.content == "true" && status == "200")
                            HttpResponseContainer(it.expectedType, true)
                        else
                            HttpResponseContainer(it.expectedType, false)
                    }

                    else -> {
                        val byteArray = dataJson.toByteArray()
                        HttpResponseContainer(it.expectedType, ByteReadChannel(byteArray))
                    }
                }
                proceedWith(responseContainer)
            }
        }

        override fun prepare(block: BaseResponseConfig.() -> Unit): BaseResponsePlugin =
            BaseResponsePlugin(BaseResponseConfig().apply(block))
    }
}