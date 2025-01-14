package com.first.homework

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.first.homework.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {

    private var binding: ActivityAlarmBinding? = null

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        createNotificationChannel()

        binding = ActivityAlarmBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        val timePick: TimePicker = findViewById(R.id.alarm_time)
        val btnSet: Button = findViewById(R.id.setAlarm)
        val alarmStatus: TextView = findViewById(R.id.alarmStatus)

        btnSet.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, timePick.hour)
            calendar.set(Calendar.MINUTE, timePick.minute)
            calendar.set(Calendar.SECOND, 0)

            val sharedPreferences = getSharedPreferences("AlarmPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putLong("alarmTime", calendar.timeInMillis)
            editor.apply()

            alarm(calendar.timeInMillis)
            alarmStatus.text = "Alarm set: ${timePick.hour}:${timePick.minute}"

            if (calendar.timeInMillis <= System.currentTimeMillis()) {
                calendar.add(Calendar.DAY_OF_YEAR, 1)
            }
        }
    }

    fun alarm(time: Long) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, Alarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "alarmChannel",
            "Будильник",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = "Канал для уведомлений будильника"

        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

}