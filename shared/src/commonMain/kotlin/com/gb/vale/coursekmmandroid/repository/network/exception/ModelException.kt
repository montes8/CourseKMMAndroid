package com.gb.vale.coursekmmandroid.repository.network.exception

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class GenericException(var messageGeneric: String = "Error en el servicio") : Exception()


class ApiException(var messageError: String = "Error",codeError : Int = 0
) : Exception()


@Serializable
data class ErrorCustom(
    @SerialName("success")
    val success: Boolean,
    @SerialName("error")
    val errorMessage: ErrorMessage
) : Exception()

@Serializable
data class ErrorMessage(
    @SerialName("errorCode")
    val errorCode: Int,
    @SerialName("errorMessage")
    val errorMessage: String,
    @SerialName("errorMessageDetail")
    val errorDetail: String,
)