package com.first.homework.data.repository

import com.first.homework.data.api.WeatherApi
import com.first.homework.data.model.WeatherResponse

class WeatherRepository(
    private val api: WeatherApi
) {
    suspend fun getWeather(city: String): WeatherResponse {
        return api.getWeather(city)
    }
}