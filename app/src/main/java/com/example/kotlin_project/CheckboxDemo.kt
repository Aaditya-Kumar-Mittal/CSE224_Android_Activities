package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CheckboxDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkbox_demo)

        val submitBtn = findViewById<Button>(R.id.submitBtn)

        val check1 = findViewById<CheckBox>(R.id.sem1)

        val check2 = findViewById<CheckBox>(R.id.sem2)

        submitBtn.setOnClickListener{

            var text = ""

            if (check1.isChecked && check2.isChecked)
            {
                text = check1.text.toString() +" and "+check2.text.toString()
            }
            else if (check1.isChecked && !check2.isChecked)
            {
                text = check1.text.toString()
            }
            else{
                text = check2.text.toString()
            }

            Toast.makeText(this, text.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}