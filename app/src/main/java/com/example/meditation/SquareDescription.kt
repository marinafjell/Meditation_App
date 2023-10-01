package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_square_description.*


class SquareDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_description)

        start.setOnClickListener {
            Log.d("tag", "Start Button was pressed")
            intent = Intent(this@SquareDescription, Square::class.java)
            startActivity(intent)
            Log.d("tag", "Square Stopwatch Intent")
        }


        tapBarMenu.setOnClickListener {
            Log.d("tag", "Menu button was pressed")
            tapBarMenu.toggle()
            Log.d("tag", "Menu was opened")
            home.setOnClickListener {
                Log.d("tag", "Home button was pressed")
                intent = Intent(this@SquareDescription, MainActivity::class.java)
                startActivity(intent)
                Log.d("tag", "Home Intent")
            }
            timer.setOnClickListener {
                Log.d("tag", "Timer button was pressed")
                intent = Intent(this@SquareDescription, TimerMinutes::class.java)
                startActivity(intent)
                Log.d("tag", "Timer Intent")
            }
            breath.setOnClickListener {
                Log.d("tag", "Breath button was pressed")
                intent = Intent(this@SquareDescription, Breath::class.java)
                startActivity(intent)
                Log.d("tag", "Breath Intent")
            }
            notes.setOnClickListener {
                Log.d("tag", "Notes button was pressed")
                intent = Intent(this@SquareDescription, ProgressDiary::class.java)
                startActivity(intent)
                Log.d("tag", "Notes Intent")
            }
        }
    }
}