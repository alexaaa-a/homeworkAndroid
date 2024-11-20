package com.first.homework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.button1.setOnClickListener {
            val intent = Intent(this@HomeActivity, InfoActivity::class.java)
            startActivity(intent)
        }
    }
}
