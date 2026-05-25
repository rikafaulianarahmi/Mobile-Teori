package com.example.latihanrecyclerview

data class ItemModel(
    val imageRes: Int,
    val nama: String,
    val deskripsi: String,
    var isSwitchOn: Boolean = false
)