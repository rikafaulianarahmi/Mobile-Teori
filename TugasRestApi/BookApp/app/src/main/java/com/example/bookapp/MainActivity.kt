package com.example.bookapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private lateinit var tvBooks: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvStatus = findViewById(R.id.tvStatus)
        tvBooks = findViewById(R.id.tvBooks)

        fetchBooks()
    }

    private fun fetchBooks() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getBooks()
                withContext(Dispatchers.Main) {
                    tvStatus.text = "Message: ${response.message} | Code: ${response.code}"
                    val sb = StringBuilder()
                    response.data.forEachIndexed { index, book ->
                        sb.append("--- Book ${index + 1} ---\n")
                        sb.append("Title  : ${book.title}\n")
                        sb.append("Author : ${book.author}\n")
                        sb.append("Year   : ${book.year}\n")
                        sb.append("Genre  : ${book.genre}\n\n")
                    }
                    tvBooks.text = sb.toString()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    tvStatus.text = "Error: ${e.message}"
                }
            }
        }
    }
}