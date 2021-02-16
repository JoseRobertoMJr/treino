package com.example.dashboard.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.common.data.local.db.FrutaDao
import com.example.dashboard.domain.model.FrutaEntity


@Database(entities = arrayOf(FrutaEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun frutaDao(): FrutaDao
}

