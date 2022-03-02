package com.example.getminutesage

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class IntroActivity : AppCompatActivity() {

    private lateinit var introPicker: TextInputEditText
    private var doubleBackToExitPressedOnce = false
    private lateinit var openNextActivity: Button

    lateinit var etName: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        etName = findViewById(R.id.et_name)
        openNextActivity = findViewById(R.id.intro_btn_checkDate)
        introPicker = findViewById(R.id.intro_date_picker)
        introPicker.setOnClickListener {
            //Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
            clickDatePicker()
        }
        openNextActivity.setOnClickListener {
            sendUserDate()
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true

        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }


    private fun clickDatePicker() {

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { view, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"

            introPicker.setText(selectedDate)

            Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show()
            Log.d("check", selectedDate)

            // tvSelectedDate?.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH)

            var theDate = sdf.parse(selectedDate)

            val selectedDateInMinutes = theDate.time / 60000

            var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            var currentDateInMinutes = currentDate.time / 60000

            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
            // result = currentDateInMinutes - selectedDateInMinutes

            // tvSelectedDateInMinutes.text = differenceInMinutes.toString()
        }, year, month, day).show()


    }

    private fun sendUserDate() {


        var date = Intent(this, MainActivity::class.java).apply {
            putExtra("DATE", introPicker.text.toString())
            putExtra("NAME", etName.text.toString())


        }
        startActivity(date)

    }
}