package com.example.bookapp

import retrofit2.http.GET

interface ApiService {
    @GET("books")
    suspend fun getBooks(): ApiResponse
}