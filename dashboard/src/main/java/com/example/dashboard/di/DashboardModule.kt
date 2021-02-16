package com.example.dashboard.di

import com.example.dashboard.data.di.dataModulesFrutas
import com.example.dashboard.domain.di.domainModulesDashboard
import com.example.dashboard.presentation.di.PresentationDashboardModules


val DashboardModules = (PresentationDashboardModules+domainModulesDashboard+dataModulesFrutas)
