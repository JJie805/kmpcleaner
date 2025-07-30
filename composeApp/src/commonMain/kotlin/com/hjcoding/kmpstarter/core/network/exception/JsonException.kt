package com.hjcoding.kmpstarter.core.network.exception

enum class ExceptionCode(value: Int) {
    JSON_NULL(10000),
    JSON_DATA_NULL(10001)
}

class JsonException(private val status: String, private val desc: String) : Exception() {
    override val message: String?
        get() = "[$status]$desc"
}
