package com.example.dashboard.domain.di

import com.example.dashboard.domain.usecase.FrutasUsaCaseImpl
import com.example.dashboard.domain.usecase.absctraction.FrutasUseCase
import org.koin.dsl.module

val useCase = module {

    factory<FrutasUseCase> {
        FrutasUsaCaseImpl(
            repositorio = get()
        )
    }

}

val domainModulesDashboard = listOf(useCase)