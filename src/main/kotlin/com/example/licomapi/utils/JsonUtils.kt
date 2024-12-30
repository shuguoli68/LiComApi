package com.example.licomapi.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue


object JsonUtils {

    val objectMapper = jacksonObjectMapper()

    fun Any.toJson(): String {
        return objectMapper.writeValueAsString(this)
    }

    inline fun <reified T> String.fromJson(): T {
        return objectMapper.readValue(this)
    }

}