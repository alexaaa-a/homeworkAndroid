package com.first.homework

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityReceiveimageBinding

class ReceiveImageActivity: AppCompatActivity() {

    private lateinit var binding: ActivityReceiveimageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiveimage)

        binding = ActivityReceiveimageBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        receiveImage()
    }

    private fun receiveImage() {
        val intent = intent
        val act = intent.action
        val type = intent.type

        if (Intent.ACTION_SEND == act && type != null && type.startsWith("image/")) {
            val imageUri: Uri? = intent.getParcelableExtra(Intent.EXTRA_STREAM)
            if (imageUri != null) {
                binding.myImg.setImageURI(imageUri)
            }
        }
    }
}