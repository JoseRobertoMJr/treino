package com.example.dashboard.presentation.di

import android.app.Presentation
import com.example.dashboard.presentation.viewmodel.DashboardFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModels = module {
    viewModel { DashboardFragmentViewModel(get()) }

}

val PresentationDashboardModules = listOf(viewModels)