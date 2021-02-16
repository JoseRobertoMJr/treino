package com.example.dashboard.data.di

import com.example.dashboard.data.repositoryImpl.FrutasRepositoryImpl
import com.example.dashboard.domain.repository.FrutasRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory<FrutasRepository> {
        FrutasRepositoryImpl(
            localDataSourceFrutas = get(),
        )
    }


}

val dataModulesFrutas = (localDataSourceModuleDashboard+repositoryModule)