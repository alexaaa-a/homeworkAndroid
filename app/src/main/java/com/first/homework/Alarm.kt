package com.first.homework

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class Alarm: BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(p0: Context?, p1: Intent?) {
        val notifyIntent = Intent(p0, NotifyActivity::class.java)
        notifyIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(
            p0,
            0,
            notifyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )


        val notification = NotificationCompat.Builder(p0!!, "alarmChannel")
            .setSmallIcon(R.drawable.cutie)
            .setContentTitle("Alarm")
            .setContentText("Your alarm went off!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = NotificationManagerCompat.from(p0)
        notificationManager.notify(1, notification)
    }
}