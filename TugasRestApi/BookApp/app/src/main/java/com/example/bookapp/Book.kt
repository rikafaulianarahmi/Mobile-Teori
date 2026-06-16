package com.example.bookapp

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val year: String,
    val genre: String
)