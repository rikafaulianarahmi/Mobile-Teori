package com.example.modul3xml.data

import com.example.modul3xml.data.database.LegoSetDao
import com.example.modul3xml.data.database.LegoThemeDao
import com.example.modul3xml.data.model.LegoSetWithTheme
import kotlinx.coroutines.flow.Flow

class LegoRepository(
    private val legoThemeDao: LegoThemeDao,
    private val legoSetDao: LegoSetDao
) {
    val allSetsWithTheme: Flow<List<LegoSetWithTheme>> = legoSetDao.getAllSetsWithTheme()
}