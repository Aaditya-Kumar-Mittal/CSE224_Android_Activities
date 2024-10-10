package com.example.kotlin_project

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_demo)

        val input = findViewById<EditText>(R.id.listInput)

        val btn = findViewById<Button>(R.id.addButton)

        //The XML List Variable
        val myList = findViewById<ListView>(R.id.dataList)

        //Empty Kotlin List
        var dataList = ArrayList<String>()

        //Adaptors act as bridge between the XML File and the Kotlin Data

        //Created an adapter to create connection
        var adapt : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,dataList)

        //Created Connection between XML and Kotlin Lists
        myList.adapter = adapt

        btn.setOnClickListener{

            var inputData = input.text.toString()

            if(inputData.isEmpty())
            {
                Toast.makeText(this, "Please enter data to enter", Toast.LENGTH_SHORT).show()
            }
            else{

                dataList.add(inputData)

                input.text.clear()

                adapt.notifyDataSetChanged()

            }
        }

    }
}