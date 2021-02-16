package com.example.dashboard.domain.usecase.absctraction

import br.com.havan.common.domain.responses.ResultUseCase
import com.example.dashboard.domain.model.FrutaEntity

interface FrutasUseCase {
    suspend fun listarFrutas(): ResultUseCase
    suspend fun inserirFruta(modelo: FrutaEntity): ResultUseCase
}