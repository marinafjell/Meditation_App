package com.example.meditation

import android.content.Intent
import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_timer.*


class Timer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)


        val num = intent.getStringExtra("minutes")
        val numSec = num.toString().toLong()
        if(numSec < 10) {
            minutesCounter.setText("0$numSec:00")
        }
        else if(numSec >= 10){
            minutesCounter.setText("$numSec:00")
        }

        startTimer.setOnClickListener {
            Log.d("tag", "Start Button was pressed")
            startTimer.visibility = View.INVISIBLE
            stopTimer.visibility = View.VISIBLE

            object : CountDownTimer(numSec * 60000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    Log.d("tag", "Timer was started")
                    val dec = DecimalFormat("00")
                    val min = (millisUntilFinished / 60000) % 60
                    val sec = (millisUntilFinished / 1000) % 60
                    minutesCounter.setText(dec.format(min) + ":" + dec.format(sec))

                    stopTimer.setOnClickListener {
                        Log.d("tag", "Stop Button was pressed")
                        cancel()
                        Log.d("tag", "Timer was stopped")
                        startTimer.visibility = View.VISIBLE
                        stopTimer.visibility = View.INVISIBLE
                        if(numSec < 10) {
                            minutesCounter.setText("0$numSec:00")
                        }
                        else if(numSec >= 10){
                            minutesCounter.setText("$numSec:00")
                        }
                    }
                }
                override fun onFinish() {
                    Log.d("tag", "Timer was finished")
                    minutesCounter.setText("00:00")
                    startTimer.visibility = View.VISIBLE
                    stopTimer.visibility = View.INVISIBLE
                    if(numSec < 10) {
                        minutesCounter.setText("0$numSec:00")
                    }
                    else if(numSec >= 10){
                        minutesCounter.setText("$numSec:00")
                    }
                }
            }.start()
        }

        tapBarMenu.setOnClickListener {
            Log.d("tag", "Menu button was pressed")
            tapBarMenu.toggle()
            Log.d("tag", "Menu was opened")
            home.setOnClickListener{
                Log.d("tag", "Home button was pressed")
                intent = Intent(this@Timer, MainActivity::class.java)
                startActivity(intent)
                Log.d("tag", "Home Intent")
            }
            timer.setOnClickListener{
                Log.d("tag", "Timer button was pressed")
                intent = Intent(this@Timer, TimerMinutes::class.java)
                startActivity(intent)
                Log.d("tag", "Timer Intent")
            }
            breath.setOnClickListener{
                Log.d("tag", "Breath button was pressed")
                intent = Intent(this@Timer, Breath::class.java)
                startActivity(intent)
                Log.d("tag", "Breath Intent")
            }
            notes.setOnClickListener{
                Log.d("tag", "Notes button was pressed")
                intent = Intent(this@Timer, ProgressDiary::class.java)
                startActivity(intent)
                Log.d("tag", "Notes Intent")
            }
        }
    }
}