package com.example.common.data.local.db

import androidx.room.*
import com.example.dashboard.domain.model.FrutaEntity

@Dao
interface FrutaDao {
    @Query("SELECT * FROM "+" frutaEntity")
    fun getAll(): List<FrutaEntity>

    @Query("SELECT * FROM frutaEntity " +
            "      WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<FrutaEntity>

    @Query(
        "SELECT * FROM frutaEntity WHERE nome LIKE :first  LIMIT 1"
    )
    fun findByName(first: String): FrutaEntity

    @Insert
    fun insertAll(vararg users: FrutaEntity)

    @Delete
    fun delete(user: FrutaEntity)
}

