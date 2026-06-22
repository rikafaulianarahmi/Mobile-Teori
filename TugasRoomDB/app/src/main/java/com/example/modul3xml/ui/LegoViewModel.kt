package com.example.modul3xml.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.modul3xml.data.LegoRepository

class LegoViewModel(private val repository: LegoRepository) : ViewModel() {
    val allSetsWithTheme = repository.allSetsWithTheme.asLiveData()
}