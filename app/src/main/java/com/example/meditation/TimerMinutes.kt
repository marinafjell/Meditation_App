package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_timer_minutes.*

class TimerMinutes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer_minutes)

        val seek = findViewById<SeekBar>(R.id.chooseMinutes)
        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                if(progress in arrayOf(1, 21)) {
                    minutes.text = "$progress минуту"
                    Log.d("tag", "Minutes text was changed")
                }
                else if(progress in arrayOf(2, 3, 4, 22, 23, 24)) {
                    minutes.text = "$progress минуты"
                    Log.d("tag", "Minutes text was changed")
                }
                else {
                    minutes.text = "$progress минут"
                    Log.d("tag", "Minutes text was changed")
                }
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        start.setOnClickListener{
            Log.d("tag", "Start button was pressed")
            startActivity(Intent(this, Timer::class.java).apply {
                putExtra("minutes", seek.progress.toString())
            })
            Log.d("tag", "Start Intent")
        }

        tapBarMenu.setOnClickListener {
            Log.d("tag", "Menu button was pressed")
            tapBarMenu.toggle()
            Log.d("tag", "Menu was opened")
            home.setOnClickListener{
                Log.d("tag", "Home button was pressed")
                intent = Intent(this@TimerMinutes, MainActivity::class.java)
                startActivity(intent)
                Log.d("tag", "Home Intent")

            }
            breath.setOnClickListener{
                Log.d("tag", "Breath button was pressed")
                intent = Intent(this@TimerMinutes, Breath::class.java)
                startActivity(intent)
                Log.d("tag", "Breath Intent")
            }
            notes.setOnClickListener{
                Log.d("tag", "Notes button was pressed")
                intent = Intent(this@TimerMinutes, ProgressDiary::class.java)
                startActivity(intent)
                Log.d("tag", "Notes Intent")
            }
        }


    }
}