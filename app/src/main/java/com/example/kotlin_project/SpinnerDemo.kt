package com.example.kotlin_project

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SpinnerDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_spinner_demo)

        var spin = findViewById<Spinner>(R.id.spin)

        //Created a list of options
        var options = arrayOf("Login","Home","Settings")

        //Linked the options list to adapter
        var myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Linking the adapter to the xml spinner variable
        spin.adapter = myAdapter

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(position)
                {
                    1 -> Toast.makeText(applicationContext,"Option 1 selected", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(applicationContext,"Option 2 selected", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(applicationContext,"Option 3 selected", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}