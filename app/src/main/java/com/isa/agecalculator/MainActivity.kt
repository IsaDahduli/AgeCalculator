package com.isa.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val dpDoB = findViewById<DatePicker>(R.id.datePicker)
        val texAge = findViewById<TextView>(R.id.tv_age)

        btnCalculate.setOnClickListener {
            val day = dpDoB.dayOfMonth
            val month = dpDoB.month
            val year = dpDoB.year

            val age = calculateAge(day, month, year)

            texAge.text = "Your age is $age years"

        }
    }

    private fun calculateAge(day: Int, month: Int, year: Int): Int {
        val dobCalendar = Calendar.getInstance()
        dobCalendar.set(year, month, day)

        val today = Calendar.getInstance()

        var age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR)

        if (today.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--
        }

        return age
    }
}