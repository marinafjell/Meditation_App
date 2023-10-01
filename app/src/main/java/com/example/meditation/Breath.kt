package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_breath.*

class Breath : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breath)

        fourseven.setOnClickListener{
            Log.d("tag", "4-7-8 button was pressed")
            intent = Intent(this@Breath, FourSevenEightDescription::class.java)
            startActivity(intent)
            Log.d("tag", "4-7-8 Description Intent")
        }

        square.setOnClickListener{
            Log.d("tag", "Square button was pressed")
            intent = Intent(this@Breath, SquareDescription::class.java)
            startActivity(intent)
            Log.d("tag", "Square Description Intent")
        }

        tapBarMenu.setOnClickListener {
            Log.d("tag", "Menu button was pressed")
            tapBarMenu.toggle()
            Log.d("tag", "Menu was opened")
            home.setOnClickListener{
                Log.d("tag", "Home button was pressed")
                intent = Intent(this@Breath, MainActivity::class.java)
                startActivity(intent)
                Log.d("tag", "Home Intent")
            }
            timer.setOnClickListener{
                Log.d("tag", "Timer button was pressed")
                intent = Intent(this@Breath, TimerMinutes::class.java)
                startActivity(intent)
                Log.d("tag", "Timer Intent")
            }
            notes.setOnClickListener{
                Log.d("tag", "Notes button was pressed")
                intent = Intent(this@Breath, ProgressDiary::class.java)
                startActivity(intent)
                Log.d("tag", "Notes Intent")
            }
        }
    }
}