package com.example.dashboard.data.source

import com.example.common.data.local.db.RoomBuilder
import com.example.common.domain.responses.ResultLocal
import com.example.dashboard.data.source.abstraction.LocalDataSourceFrutas
import com.example.dashboard.domain.model.FrutaEntity

class LocalDataSourceFrutasImpl(val room: RoomBuilder) : LocalDataSourceFrutas {

    override fun listarFrutas(): ResultLocal<List<FrutaEntity>> = try {
        ResultLocal.Success(room.db.value.frutaDao().getAll())
    } catch (throwable: Throwable) {
        ResultLocal.ErrorResponse(throwable)
    }


    override fun inserirFruta(fruta: FrutaEntity) = try {
        room.db.value.frutaDao().insertAll(fruta)
        ResultLocal.Success(true)
    } catch (throwable: Throwable) {
        ResultLocal.ErrorResponse(throwable)
    }

}
