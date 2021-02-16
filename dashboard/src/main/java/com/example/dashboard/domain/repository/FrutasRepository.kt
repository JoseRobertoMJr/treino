package com.example.dashboard.domain.repository

import br.com.havan.common.domain.responses.ResultRequired
import com.example.dashboard.domain.model.FrutaEntity
import com.example.dashboard.presedntation.Fruta

interface FrutasRepository {

    suspend fun listaFrutas(): ResultRequired<List<FrutaEntity>>

    suspend fun inserirFruta(modelo: FrutaEntity): ResultRequired<Boolean>

}