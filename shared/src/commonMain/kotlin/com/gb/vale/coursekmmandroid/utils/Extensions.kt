package com.gb.vale.coursekmmandroid.utils

import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*


suspend inline fun <reified T> HttpResponse.validateData(): T {
    try {
        return this.body()
    } catch (ex: Exception) {
        throw NullPointerException()
    }
}


fun bodyP(parameters: Map<String, Any>): Parameters {
    val params: Parameters = Parameters.build {
        parameters.forEach { (key, value) -> append(key, value.toString()) }
    }

    println("Params: $params")
    return params
}