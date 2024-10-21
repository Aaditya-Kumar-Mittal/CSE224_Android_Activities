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

class CAPracticeListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_list_view)

        val addItem = findViewById<Button>(R.id.addListItem)
        val inputItem = findViewById<EditText>(R.id.inputListData1)
        val practiceList = findViewById<ListView>(R.id.practiceList1)

        //Create empty Kotlin List
        var kotlinList = ArrayList<String>()

        //Create adapter to create connection
        var listAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, kotlinList)

        //Attach it to XML List
        practiceList.adapter = listAdapter

        //Add functionality to button
        addItem.setOnClickListener{

            var listText = inputItem.text.toString()

            if (listText.isEmpty())
            {
                Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show()
            }
            else{

                //Add to data list
                kotlinList.add(listText)

                //Clear the input
                inputItem.text.clear()

                listAdapter.notifyDataSetChanged()

            }
        }
    }
}