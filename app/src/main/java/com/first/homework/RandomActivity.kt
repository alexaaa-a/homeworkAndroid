package com.first.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityRandomBinding
import kotlin.random.Random

class RandomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRandomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        binding = ActivityRandomBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        savedInstanceState.let {
            binding.generate.setOnClickListener {
                val numn = Random.nextInt(1, 1001)
                binding.num.text = numn.toString()
            }
        }
    }
}