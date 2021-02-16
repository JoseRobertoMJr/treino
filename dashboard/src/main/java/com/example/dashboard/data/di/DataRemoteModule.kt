package com.example.dashboard.data.di

import android.content.Context
import androidx.room.Room
import com.example.common.data.local.db.RoomBuilder
import com.example.dashboard.data.local.db.AppDatabase
import com.example.dashboard.data.source.LocalDataSourceFrutasImpl
import com.example.dashboard.data.source.abstraction.LocalDataSourceFrutas
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val localDataSourceModuleDashboard = module {
    single { createRoom(get()) }

    factory<LocalDataSourceFrutas> {
        LocalDataSourceFrutasImpl(
             createRoom(androidContext())
        )
    }

}

fun createRoom(context: Context): RoomBuilder {
    return RoomBuilder(context)
}