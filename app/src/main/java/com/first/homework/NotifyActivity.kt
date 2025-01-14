package com.first.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityNotifyBinding

class NotifyActivity : AppCompatActivity() {

    private var binding: ActivityNotifyBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify)

        binding = ActivityNotifyBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }
}