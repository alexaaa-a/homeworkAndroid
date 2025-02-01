package com.first.homework

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MusicPlayer : Service() {

    private var mediaPlayer: MediaPlayer? = null
    private val tracks = listOf(
        R.raw.nervy_nervy,
        R.raw.kis_kis_dirt,
        R.raw.nervy_vorony,
        R.raw.kis_kis_tears,
        R.raw.nervy_schaste,
        R.raw.kis_kis_entrance,
        R.raw.kis_kis_im_tired,
        R.raw.kis_kis_trifle,
        R.raw.papin_olympos_day_when_we_met_with_you,
        R.raw.papin_olympos_temno_orangevy_zakat
    )
    private val trackNames = listOf(
        "Нервы - Нервы",
        "Кис-кис - Грязь",
        "Нервы - Вороны",
        "Кис-кис - Слезы",
        "Нервы - Счастье",
        "Кис-кис - Падик",
        "Кис-кис - Достало",
        "Кис-кис - Мелочь",
        "Папин Олимпос - День, когда мы встретились с тобой",
        "Папин Олимпос - Темно-оранжевый закат"
    )
    private var trackIndex = 0

    inner class MusicBinder : Binder() {
        fun service(): MusicPlayer = this@MusicPlayer
    }

    private val binder = MusicBinder()

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        initializeMediaPlayer()
    }

    private fun initializeMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, tracks[trackIndex])
        mediaPlayer?.setOnCompletionListener {
            nextTrack()
        }
    }

    fun playMusic() {
        if (mediaPlayer?.isPlaying == false) {
            mediaPlayer?.start()
        }
    }

    fun pauseMusic() {
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        }
    }

    fun nextTrack() {
        trackIndex = (trackIndex + 1) % tracks.size
        changeTrack()
    }

    fun previousTrack() {
        trackIndex = if (trackIndex - 1 < 0) {
            tracks.size - 1
        } else {
            trackIndex - 1
        }
        changeTrack()
    }

    private fun changeTrack() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, tracks[trackIndex])
        mediaPlayer?.start()
        mediaPlayer?.setOnCompletionListener {
            nextTrack()
        }
    }

    fun getCurrentTrackName(): String {
        return trackNames[trackIndex]
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }
}
