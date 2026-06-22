package com.example.modul3xml.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class LegoSetWithTheme(
    @Embedded val legoSet: LegoSet,
    @Relation(
        parentColumn = "themeId",
        entityColumn = "id"
    )
    val theme: LegoTheme
)