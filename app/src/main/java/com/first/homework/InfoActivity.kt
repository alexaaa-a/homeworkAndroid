package com.first.homework

import android.net.Uri
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityInfoBinding

class InfoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        binding = ActivityInfoBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.button1.setOnClickListener {
            val intent = Intent(this@InfoActivity, RandomActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent2 = Intent(this@InfoActivity, ReceiveImageActivity::class.java)
            startActivity(intent2)
        }

        binding.button3.setOnClickListener {
            val intent3 = Uri.parse("https://ru.pinterest.com/pin/969892469747742346/").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage) }
            startActivity(intent3)
        }

    }
}