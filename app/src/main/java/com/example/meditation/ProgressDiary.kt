package com.example.meditation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_progress_diary.*


class ProgressDiary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_diary)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        val file_name = "Note"
        button_add.setOnClickListener {
            Log.d("tag", "Add button was pressed")
            val string = editTextTextMultiLine.text
            this.openFileOutput(file_name, Context.MODE_PRIVATE).write(string.toString().toByteArray())
            Log.d("tag", "Text was saved")
        }
        button_read.setOnClickListener {
            Log.d("tag", "Read button was pressed")
            this.openFileInput(file_name).use {
                val inpt = it.readBytes().toString(Charsets.UTF_8)
                editTextTextMultiLine.setText(inpt)
                Log.d("tag", "Savext was shown")
            }
        }
        tapBarMenu.setOnClickListener {
            Log.d("tag", "Menu button was pressed")
            tapBarMenu.toggle()
            Log.d("tag", "Menu was opened")
            home.setOnClickListener {
                Log.d("tag", "Home button was pressed")
                intent = Intent(this@ProgressDiary, MainActivity::class.java)
                startActivity(intent)
                Log.d("tag", "Home Intent")
            }
            timer.setOnClickListener {
                Log.d("tag", "Timer button was pressed")
                intent = Intent(this@ProgressDiary, TimerMinutes::class.java)
                startActivity(intent)
                Log.d("tag", "Timer Intent")
            }
            breath.setOnClickListener {
                Log.d("tag", "Breath button was pressed")
                intent = Intent(this@ProgressDiary, Breath::class.java)
                startActivity(intent)
                Log.d("tag", "Breath Intent")
            }
        }

    }
}