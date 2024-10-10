package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class linear_layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_linear_layout)

        //Add ids of the widget
        var input_a = findViewById<EditText>(R.id.editText11)
        var input_b = findViewById<EditText>(R.id.editText22)
        var btnSubmit = findViewById<Button>(R.id.button1)
        var tV = findViewById<TextView>(R.id.textView11)

        btnSubmit.setOnClickListener{
            var text1 = input_a.text.toString()
            var text2 = input_b.text.toString()
            tV.text = "My name is "+text1+" and registration number is "+text2
        }
    }
}