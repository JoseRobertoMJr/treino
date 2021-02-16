package com.example.dashboard.data.source.abstraction

import com.example.common.domain.responses.ResultLocal
import com.example.dashboard.domain.model.FrutaEntity

interface LocalDataSourceFrutas {
    fun listarFrutas(): ResultLocal<List<FrutaEntity>>
    fun inserirFruta(fruta: FrutaEntity): ResultLocal<Boolean>

}