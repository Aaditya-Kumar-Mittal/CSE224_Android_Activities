package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioButtonDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio_button_demo)

        val btn = findViewById<Button>(R.id.colorButton)

        btn.setOnClickListener{

            val colorGrp = findViewById<RadioGroup>(R.id.colorGroup)

            val colorId = colorGrp.checkedRadioButtonId

            var favColor = findViewById<RadioButton>(colorId)

            Toast.makeText(this,favColor.text,Toast.LENGTH_SHORT).show()
        }
    }
}