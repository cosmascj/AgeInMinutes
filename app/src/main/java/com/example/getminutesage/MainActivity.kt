package com.example.getminutesage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

  private  var tvSelectedDate: TextView? = null
    private  lateinit var tvSelectedDateInMinutes: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate= findViewById(R.id.tvSelectedDate)
        tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }


    private fun clickDatePicker(){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { view, year, month, dayOfMonth ->


           // Toast.makeText(this, "$year, $month", Toast.LENGTH_SHORT).show()


            val selectedDate = "$dayOfMonth/${month+1}/$year"

            tvSelectedDate?.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH)

            var theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate.time/ 60000

            var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            var currentDateInMinutes = currentDate.time/60000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

            tvSelectedDateInMinutes.text = differenceInMinutes.toString()



        }, year, month, day).show()


    }
}