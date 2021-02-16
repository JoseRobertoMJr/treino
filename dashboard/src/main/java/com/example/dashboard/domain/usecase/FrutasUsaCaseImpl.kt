package com.example.dashboard.domain.usecase

import br.com.havan.common.domain.responses.ResultRequired
import br.com.havan.common.domain.responses.ResultUseCase
import com.example.dashboard.domain.model.FrutaEntity
import com.example.dashboard.domain.repository.FrutasRepository
import com.example.dashboard.domain.usecase.absctraction.FrutasUseCase

class FrutasUsaCaseImpl(val repositorio: FrutasRepository) : FrutasUseCase {
    override suspend fun listarFrutas(): ResultUseCase {
        val response = repositorio.listaFrutas()

        return when (response) {
            is ResultRequired.Success -> {
                ResultUseCase.Model(response.modelo)
            }
            is ResultRequired.Warning -> {
                ResultUseCase.Aviso(response.aviso)
            }
            is ResultRequired.Error -> {
                ResultUseCase.Error(response.throwable)
            }
            is ResultRequired.Login -> {
                ResultUseCase.Login(response.throwable)
            }
        }
    }

    override suspend fun inserirFruta(modelo: FrutaEntity): ResultUseCase {
        val response = repositorio.inserirFruta(modelo)

        return when (response) {
            is ResultRequired.Success -> {
                ResultUseCase.Model(response.modelo)
            }
            is ResultRequired.Warning -> {
                ResultUseCase.Aviso(response.aviso)
            }
            is ResultRequired.Error -> {
                ResultUseCase.Error(response.throwable)
            }
            is ResultRequired.Login -> {
                ResultUseCase.Login(response.throwable)
            }
        }

    }

}
