package com.example.dashboard.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FrutaEntity(
    @PrimaryKey val uid: Int? = null,
    @ColumnInfo(name = "nome") val nome: String?,
)
