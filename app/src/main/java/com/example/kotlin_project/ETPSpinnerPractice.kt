package com.example.kotlin_project

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPSpinnerPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etpspinner_practice)

        // Make a List of Array Strings
        var exams = arrayOf("INT220", "INT221", "INT222", "INT223", "INT224")

        //Fetch the spinner
        var etpSpinner = findViewById<Spinner>(R.id.spinnerETP)

        //Create an array Adapter
        var spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, exams)

        //Create its drop down view resource
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Attach the adapter to the spinner
        etpSpinner.adapter = spinnerAdapter

        etpSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> Toast.makeText(applicationContext, exams[0], Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(applicationContext, exams[1], Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext, exams[2], Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext, exams[3], Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(applicationContext, exams[4], Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}