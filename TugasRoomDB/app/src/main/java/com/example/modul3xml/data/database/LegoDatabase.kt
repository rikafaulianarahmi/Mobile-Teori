package com.example.modul3xml.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.modul3xml.data.model.LegoSet
import com.example.modul3xml.data.model.LegoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.example.modul3xml.R

@Database(entities = [LegoTheme::class, LegoSet::class], version = 1, exportSchema = false)
abstract class LegoDatabase : RoomDatabase() {

    abstract fun legoThemeDao(): LegoThemeDao
    abstract fun legoSetDao(): LegoSetDao

    companion object {
        @Volatile
        private var INSTANCE: LegoDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LegoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LegoDatabase::class.java,
                    "lego_database"
                )
                    .addCallback(LegoDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class LegoDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.legoThemeDao(), database.legoSetDao())
                }
            }
        }

        suspend fun populateDatabase(themeDao: LegoThemeDao, setDao: LegoSetDao) {
            val cityId = 1
            val technicId = 2
            val starWarsId = 3

            themeDao.insert(LegoTheme(cityId, "City", "Kehidupan kota modern dengan polisi, pemadam, dan konstruksi"))
            themeDao.insert(LegoTheme(technicId, "Technic", "Set mekanik kompleks dengan fungsi engineering nyata"))
            themeDao.insert(LegoTheme(starWarsId, "Star Wars", "Koleksi ikonik dari galaksi jauh nan jauh"))

            setDao.insert(LegoSet(title = "Police Station", year = 2023, pieces = 668, description = "Kantor polisi kota lengkap dengan penjara dan kendaraan.", imageRes = R.drawable.lego1, webUrl = "https://www.lego.com", themeId = cityId))
            setDao.insert(LegoSet(title = "Fire Brigade", year = 2022, pieces = 766, description = "Truk pemadam kebakaran dengan tangga hidrolik.", imageRes = R.drawable.lego2, webUrl = "https://www.lego.com", themeId = cityId))
            setDao.insert(LegoSet(title = "Bugatti Chiron", year = 2023, pieces = 3599, description = "Replika detail supercar Bugatti Chiron.", imageRes = R.drawable.lego3, webUrl = "https://www.lego.com", themeId = technicId))
            setDao.insert(LegoSet(title = "Millennium Falcon", year = 2023, pieces = 7541, description = "Set ikonik kapal Han Solo dengan detail luar biasa.", imageRes = R.drawable.lego4, webUrl = "https://www.lego.com", themeId = starWarsId))
            setDao.insert(LegoSet(title = "AT-AT Walker", year = 2022, pieces = 6785, description = "Kendaraan tempur Empire yang legendaris.", imageRes = R.drawable.lego5, webUrl = "https://www.lego.com", themeId = starWarsId))
        }
    }
}