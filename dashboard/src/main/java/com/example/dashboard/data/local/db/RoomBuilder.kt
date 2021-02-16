package com.example.common.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.dashboard.data.local.db.AppDatabase

class RoomBuilder(context: Context) {

    val db = lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "frutas"
        ).build()
    }
}


