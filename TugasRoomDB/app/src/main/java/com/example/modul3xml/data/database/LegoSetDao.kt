package com.example.modul3xml.data.database

import androidx.room.*
import com.example.modul3xml.data.model.LegoSet
import com.example.modul3xml.data.model.LegoSetWithTheme
import kotlinx.coroutines.flow.Flow

@Dao
interface LegoSetDao {
    @Query("SELECT * FROM lego_sets")
    fun getAllSets(): Flow<List<LegoSet>>

    @Transaction
    @Query("SELECT * FROM lego_sets")
    fun getAllSetsWithTheme(): Flow<List<LegoSetWithTheme>>

    @Transaction
    @Query("SELECT * FROM lego_sets WHERE themeId = :themeId")
    fun getSetsByTheme(themeId: Int): Flow<List<LegoSetWithTheme>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(legoSet: LegoSet)

    @Delete
    suspend fun delete(legoSet: LegoSet)
}