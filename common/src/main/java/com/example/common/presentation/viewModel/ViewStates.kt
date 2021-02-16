package com.example.common.presentation.viewModel

sealed class ViewStates {
    object Carregando : ViewStates()
    class Sucesso<T>(val list: T): ViewStates()
    class Aviso(val aviso: String): ViewStates()
    class Error(val erro: Throwable): ViewStates()
    class Login(val erro: Throwable): ViewStates()
    class CamposInvalidos<T>(val campos: T) : ViewStates()
}