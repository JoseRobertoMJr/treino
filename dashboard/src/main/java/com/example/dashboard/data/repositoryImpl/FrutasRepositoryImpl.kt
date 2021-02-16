package com.example.dashboard.data.repositoryImpl

import br.com.havan.common.domain.responses.ResultRequired
import com.example.common.domain.responses.ResultLocal
import com.example.dashboard.data.source.abstraction.LocalDataSourceFrutas
import com.example.dashboard.domain.model.FrutaEntity
import com.example.dashboard.domain.repository.FrutasRepository
import com.example.dashboard.presedntation.Fruta

class FrutasRepositoryImpl(val localDataSourceFrutas : LocalDataSourceFrutas): FrutasRepository {
    override suspend fun listaFrutas(): ResultRequired<List<FrutaEntity>> {
       val resultLocal = localDataSourceFrutas.listarFrutas()

        return when (resultLocal) {
            is ResultLocal.Success -> {
                val mapped = resultLocal.response

                ResultRequired.Success(
                    modelo = mapped
                )
            }
            is ResultLocal.ErrorResponse -> {
                ResultRequired.Error(resultLocal.throwable)
            }
        }
    }

    override suspend fun inserirFruta(modelo: FrutaEntity): ResultRequired<Boolean> {
        val resultLocal = localDataSourceFrutas.inserirFruta(modelo)

        return when (resultLocal) {
            is ResultLocal.Success -> {
                val mapped = resultLocal.response

                ResultRequired.Success(
                    modelo = mapped
                )
            }
            is ResultLocal.ErrorResponse -> {
                ResultRequired.Error(resultLocal.throwable)
            }
        }
    }
}