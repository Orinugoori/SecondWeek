package com.example.secondweek

import android.content.Context
import android.media.MediaPlayer

class Sound(private val context : Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.vintage)

    fun playSound() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(context, R.raw.vintage)
        }
        mediaPlayer.start()
    }

    fun release() {
        mediaPlayer.release()
    }
}