package com.example.bookapp

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@OptIn(InternalSerializationApi::class)
@Serializable
data class ApiResponse(
    val message: String,
    val code: String,
    val data: List<Book>
)