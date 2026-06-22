package com.example.modul3xml.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "lego_sets",
    foreignKeys = [
        ForeignKey(
            entity = LegoTheme::class,
            parentColumns = ["id"],
            childColumns = ["themeId"],
            onDelete = ForeignKey.Companion.CASCADE
        )
    ],
    indices = [Index("themeId")]
)
data class LegoSet(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val year: Int,
    val pieces: Int,
    val description: String,
    val imageRes: Int,
    val webUrl: String,
    val themeId: Int  // Foreign Key ke LegoTheme
)