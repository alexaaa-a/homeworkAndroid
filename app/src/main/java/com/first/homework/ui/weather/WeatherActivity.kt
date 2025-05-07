package com.first.homework.ui.weather

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.first.homework.App
import com.first.homework.data.repository.WeatherRepository
import com.first.homework.databinding.ActivityWeatherBinding
import com.first.homework.viewmodel.WeatherState
import com.first.homework.viewmodel.WeatherViewModel
import javax.inject.Inject

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding

    @Inject
    lateinit var repository: WeatherRepository

    private val viewModel: WeatherViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return WeatherViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val city = intent.getStringExtra("CITY") ?: run {
            Toast.makeText(this, "Город не указан", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        setupObservers()
        viewModel.loadWeather(city)
    }

    private fun setupObservers() {
        viewModel.state.observe(this) { state ->
            when (state) {
                is WeatherState.Loading -> binding.progressBar.visibility = View.VISIBLE
                is WeatherState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.temperatureText.text = "${state.weather.main.temp}°C"
                    binding.descriptionText.text = state.weather.weather[0].description
                    Glide.with(this)
                        .load("https://openweathermap.org/img/w/${state.weather.weather[0].icon}.png")
                        .into(binding.weatherIcon)
                }
                is WeatherState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
