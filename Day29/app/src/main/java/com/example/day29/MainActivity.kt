package com.example.day29

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var totalTime: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playbutton = findViewById<ImageView>(R.id.play)
        val pausebutton = findViewById<ImageView>(R.id.pause)
        val stopbutton = findViewById<ImageView>(R.id.stop)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.setVolume(1f, 1f)
        totalTime = mediaPlayer.duration

        playbutton.setOnClickListener {
            mediaPlayer.start()
        }

        pausebutton.setOnClickListener {
            mediaPlayer.pause()
        }

        stopbutton.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        // when user changes the seek bar the music should point to it
        seekbar.max = totalTime
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p2) {
                    mediaPlayer.seekTo(p1)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        // handling seekbar based on the music
        android.os.Handler().postDelayed({
            try {
                seekbar.progress = mediaPlayer.currentPosition
            } catch (exception: Exception) {
                seekbar.progress = 0
            }
        }, 1000)
    }
}
