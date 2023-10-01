package com.example.meditation

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_four_seven_eight.*


class FourSevenEight : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_seven_eight)

        start.setOnClickListener {
            Log.d("tag", "Start Button was pressed")
            countup.start()
            Log.d("tag", "Stopwatch was started")
            start.visibility = View.INVISIBLE
            stop.visibility = View.VISIBLE
            countup.setOnChronometerTickListener {
                stop.setOnClickListener {
                    Log.d("tag", "Stop Button was pressed")
                    countup.stop()
                    Log.d("tag", "Stopwatch was stopped")
                    countup.setBase(SystemClock.elapsedRealtime())
                    stop.visibility = View.INVISIBLE
                    start.visibility = View.VISIBLE
                }
            }
        }

        tapBarMenu.setOnClickListener {
            Log.d("tag", "Menu button was pressed")
            tapBarMenu.toggle()
            Log.d("tag", "Menu was opened")
            home.setOnClickListener {
                Log.d("tag", "Home button was pressed")
                intent = Intent(this@FourSevenEight, MainActivity::class.java)
                startActivity(intent)
                Log.d("tag", "Home Intent")
            }
            timer.setOnClickListener {
                Log.d("tag", "Timer button was pressed")
                intent = Intent(this@FourSevenEight, TimerMinutes::class.java)
                startActivity(intent)
                Log.d("tag", "Timer Intent")
            }
            breath.setOnClickListener {
                Log.d("tag", "Breath button was pressed")
                intent = Intent(this@FourSevenEight, Breath::class.java)
                startActivity(intent)
                Log.d("tag", "Breath Intent")
            }
            notes.setOnClickListener {
                Log.d("tag", "Notes button was pressed")
                intent = Intent(this@FourSevenEight, ProgressDiary::class.java)
                startActivity(intent)
                Log.d("tag", "Notes Intent")
            }
        }
    }
}