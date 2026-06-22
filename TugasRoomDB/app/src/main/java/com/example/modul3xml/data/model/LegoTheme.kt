package com.example.modul3xml.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lego_themes")
data class LegoTheme(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String
)