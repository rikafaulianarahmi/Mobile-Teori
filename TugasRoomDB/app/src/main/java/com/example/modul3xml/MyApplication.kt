package com.example.modul3xml

import android.app.Application
import com.example.modul3xml.data.LegoRepository
import com.example.modul3xml.data.database.LegoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {
        LegoDatabase.getDatabase(this, applicationScope)
    }

    val repository by lazy {
        LegoRepository(
            database.legoThemeDao(),
            database.legoSetDao()
        )
    }
}