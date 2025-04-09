package com.first.homework.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun validateCityName(city: String): Boolean {
        return city.length in 3..50
    }
}