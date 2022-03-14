package com.example.getminutesage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    private  var tvSelectedDate: TextView? = null
    private  lateinit var tvSelectedDateInMinutes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar_members_activity)

        tvSelectedDate= findViewById(R.id.tvSelectedDate)

        tvSelectedDateInMinutes = findViewById(R.id.tvSelectedDateInMinutes)

        var intentValue =  intent.getStringExtra("DATE")

       intentValue.toString()
        if (intentValue != null) {
           // Log.d("u", intentValue)
        }

        setupActionBar()

       // tvSelectedDateInMinutes.apply { text= intentValue.toString() }


        var intentSecondValue =  intent.getStringExtra("NAME")



        tvSelectedDate?.apply { text= intentSecondValue.toString() }


        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

       var theDate = sdf.parse("$intentValue")
        val selectedDateInMinutes = theDate.time/ 60000



       var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

       var currentDateInMinutes = currentDate.time/60000

        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

         tvSelectedDateInMinutes?.apply { text= differenceInMinutes.toString() }

    }

    private fun setupActionBar() {

        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
            actionBar.title = resources.getString(R.string.my_profile)


        }

        toolbar.setNavigationOnClickListener { onBackPressed() }
    }




}