package com.example.modul3xml.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.modul3xml.data.model.LegoTheme
import kotlinx.coroutines.flow.Flow

@Dao
interface LegoThemeDao {
    @Query("SELECT * FROM lego_themes")
    fun getAllThemes(): Flow<List<LegoTheme>>

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun insert(theme: LegoTheme)

    @Delete
    suspend fun delete(theme: LegoTheme)
}