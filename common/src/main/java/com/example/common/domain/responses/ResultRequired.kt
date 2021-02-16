package br.com.havan.common.domain.responses

sealed class ResultRequired<out T> {
    data class Success<out T>(val modelo: T): ResultRequired<T>()
    data class Error(val throwable: Throwable): ResultRequired<Nothing>()
    data class Login(val throwable: Throwable): ResultRequired<Nothing>()
    class Warning(val aviso: String): ResultRequired<Nothing>()
}