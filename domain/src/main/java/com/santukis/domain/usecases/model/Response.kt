package com.santukis.domain.usecases.model

sealed class Response<out Left, out Right> {

    class Success<out Right>(val value: Right) : Response<Nothing, Right>()
    class Error<out Left>(val error: Throwable? = null, val value: Left? = null) : Response<Left, Nothing>()

    fun isError(): Boolean = this is Error
    fun isSuccess(): Boolean = this is Success
}

fun <Left, Right> Response<Left, Right>.getOrNull(): Right? =
    (this as? Response.Success)?.value

fun <Left, Right> Response<Left, Right>.getErrorValueOrNull(): Left? =
    (this as? Response.Error)?.value
