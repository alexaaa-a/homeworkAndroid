package com.first.homework.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityMainBinding
import com.first.homework.ui.weather.WeatherActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val city = binding.cityInput.text.toString().trim()
            if (city.length in 3..50) {
                startActivity(Intent(this, WeatherActivity::class.java).apply {
                    putExtra("CITY", city)
                })
            } else {
                Toast.makeText(this, "Введите корректное название города (3-50 символов)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}