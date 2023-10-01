package com.example.meditation
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        timer.setOnClickListener{
            Log.d("tag", "Timer button was pressed")
            intent = Intent(this@MainActivity, TimerMinutes::class.java)
            startActivity(intent)
            Log.d("tag", "Timer Minutes Intent")
        }

        diary.setOnClickListener{
            Log.d("tag", "Diary button was pressed")
            intent = Intent(this@MainActivity, ProgressDiary::class.java)
            startActivity(intent)
            Log.d("tag", "Diary Intent")
        }


        val data: Array<String> = arrayOf("ДЫХАНИЕ","4-7-8", "Квадратное дыхание")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, data)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 == 1){
                    intent = Intent(this@MainActivity, FourSevenEightDescription::class.java)
                    startActivity(intent)
                    Log.d("tag", "4-7-8 Description Intent")
                }
                else if(p2 == 2) {
                    intent = Intent(this@MainActivity, SquareDescription::class.java)
                    startActivity(intent)
                    Log.d("tag", "Square Description Intent")
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

}