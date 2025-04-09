package com.first.homework.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.first.homework.data.model.WeatherResponse
import com.first.homework.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _state = MutableLiveData<WeatherState>()
    val state: LiveData<WeatherState> = _state

    fun loadWeather(city: String) {
        viewModelScope.launch {
            _state.value = WeatherState.Loading
            try {
                val weather = repository.getWeather(city)
                _state.value = WeatherState.Success(weather)
            } catch (e: Exception) {
                _state.value = WeatherState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class WeatherState {
    object Loading : WeatherState()
    data class Success(val weather: WeatherResponse) : WeatherState()
    data class Error(val message: String) : WeatherState()
}