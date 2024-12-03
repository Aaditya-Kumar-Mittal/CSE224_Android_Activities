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

class ETPListViewPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etplist_view_practice)

        //Fetch all the elements
        var l = findViewById<ListView>(R.id.listviewETP)
        var e = findViewById<EditText>(R.id.editListETP)
        var b = findViewById<Button>(R.id.addListETP)

        //Create empty Kotlin List
        var kotlinList = ArrayList<String>()

        //Create a list adapter
        var listAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, kotlinList)

        //Attach adapter to xml list
        l.adapter = listAdapter

        //Add functionality to button
        b.setOnClickListener {

            var listText = e.text.toString()

            if (listText.isEmpty()) {
                Toast.makeText(this, "Please enter some data to add to list", Toast.LENGTH_SHORT).show()
            } else {

                //Add to data list
                kotlinList.add(listText)

                //Clear the input
                e.text.clear()

                //Reflect changes in adapter
                listAdapter.notifyDataSetChanged()
            }
        }
    }
}
