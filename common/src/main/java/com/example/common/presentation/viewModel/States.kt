package com.example.common.presentation.viewModel

import com.example.common.presentation.viewModel.model.ErrorModel

sealed class States<out T> {
    object Carregando : States<Nothing>()
    data class Sucesso<T>(val data: T) : States<T>()
    data class CamposInvalidos<T>(val campos: T) : States<T>()
    data class Erro(val erroModel: ErrorModel?) : States<Nothing>()
}