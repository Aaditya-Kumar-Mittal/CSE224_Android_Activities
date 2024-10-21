package com.example.kotlin_project

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeSpinner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_spinner)

        //Create an Array of Options
        var fruits = arrayOf("Apple", "Banana", "Mango", "Orange", "Pineapple", "Strawberry", "Grapes")

        //Fetch the XML Spinner
        var practiceSpinner = findViewById<Spinner>(R.id.practiceSpinner1)

        //Create adapter for Spinner
        var spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, fruits)

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        practiceSpinner.adapter = spinnerAdapter

        practiceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(position)
                {
                    1-> Toast.makeText(applicationContext, fruits[0], Toast.LENGTH_SHORT).show()
                    2-> Toast.makeText(applicationContext, fruits[1], Toast.LENGTH_SHORT).show()
                    3-> Toast.makeText(applicationContext, fruits[2], Toast.LENGTH_SHORT).show()
                    4-> Toast.makeText(applicationContext, fruits[3], Toast.LENGTH_SHORT).show()
                    5-> Toast.makeText(applicationContext, fruits[4], Toast.LENGTH_SHORT).show()

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}