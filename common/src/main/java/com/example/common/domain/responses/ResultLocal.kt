package com.example.common.domain.responses

sealed class ResultLocal<out T> {
    data class Success<out T>(val response: T) : ResultLocal<T>()
    data class ErrorResponse(val throwable: Throwable) : ResultLocal<Nothing>()
}