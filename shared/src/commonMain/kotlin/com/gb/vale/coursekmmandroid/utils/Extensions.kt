package com.gb.vale.coursekmmandroid.utils

import com.gb.vale.coursekmmandroid.repository.network.exception.ApiException
import com.gb.vale.coursekmmandroid.repository.network.exception.ErrorCustom
import com.gb.vale.coursekmmandroid.repository.network.exception.GenericException
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.errors.*
import kotlinx.serialization.json.Json


suspend inline fun <reified T> HttpResponse.validateData(): T {
    try {
        return this.body()
    } catch (ex: Exception) {
        throw NullPointerException()
    }
}


suspend fun errorMapper(exception : Throwable){
    if (exception is IOException){
        throw GenericException(messageGeneric = "Error en la peticion del servicio")
    }else{
        val clientException = exception as? ClientRequestException ?: return
        val exceptionResponse = clientException.response
        if (exceptionResponse.status == HttpStatusCode.NotFound) {
            val exceptionResponseText = exceptionResponse.bodyAsText()
            val response: ErrorCustom = Json.decodeFromString(
                ErrorCustom.serializer(),
                exceptionResponseText
            )
            throw ApiException(response.errorMessage.errorMessage, response.errorMessage.errorCode)
        }else if (exceptionResponse.status == HttpStatusCode.InternalServerError){
            val exceptionResponseText = exceptionResponse.bodyAsText()
            throw ApiException(exceptionResponseText, 0)
        }else{
            throw exception
        }
    }

}

fun bodyP(parameters: Map<String, Any>): Parameters {
    val params: Parameters = Parameters.build {
        parameters.forEach { (key, value) -> append(key, value.toString()) }
    }

    println("Params: $params")
    return params
}