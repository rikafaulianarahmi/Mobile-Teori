package com.example.modul3xml.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modul3xml.data.LegoRepository

class LegoViewModelFactory(private val repository: LegoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LegoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LegoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}