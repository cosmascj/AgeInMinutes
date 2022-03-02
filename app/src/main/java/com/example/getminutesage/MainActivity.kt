package com.example.getminutesage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

  private  var tvSelectedDate: TextView? = null
    private  lateinit var tvSelectedDateInMinutes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSelectedDate= findViewById(R.id.tvSelectedDate)
        tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes)

        var intentValue =  intent.getStringExtra("DATE")

       intentValue.toString()
        if (intentValue != null) {
            Log.d("u", intentValue)
        }

       // tvSelectedDateInMinutes.apply { text= intentValue.toString() }


       // var intentSecondValue =  intent.getStringExtra("NAME")



       // tvSelectedDate?.apply { text= intentSecondValue.toString() }


        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

       var theDate = sdf.parse("$intentValue")
        Log.d("uu", theDate.toString())

        val selectedDateInMinutes = theDate.time/ 60000

        Log.d("uuu", selectedDateInMinutes.toString())


       var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
        Log.d("uuuu", currentDate.toString())

       var currentDateInMinutes = currentDate.time/60000
        Log.d("uuuuuu", currentDateInMinutes.toString())


        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
        Log.d("uuu", differenceInMinutes.toString())


    }


/*
    private fun clickDatePicker(){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { view, year, month, dayOfMonth ->




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
*/
}