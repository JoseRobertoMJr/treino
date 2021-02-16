package br.com.havan.common.domain.responses

sealed class ResultUseCase {
    data class Model<T>(val modelo: T): ResultUseCase()
    data class Aviso(val aviso: String): ResultUseCase()
    data class Error(val erro: Throwable): ResultUseCase()
    data class Login(val erro: Throwable): ResultUseCase()
}