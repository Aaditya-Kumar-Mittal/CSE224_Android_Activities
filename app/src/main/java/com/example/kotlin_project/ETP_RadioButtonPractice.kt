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

class ETP_RadioButtonPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_radio_button_practice)

        val radioGrp = findViewById<RadioGroup>(R.id.etpRadioGroup)
        val submitBtn = findViewById<Button>(R.id.etpRadioSubmit)

        submitBtn.setOnClickListener {
            val radioId = radioGrp.checkedRadioButtonId
            val color = findViewById<RadioButton>(radioId)
            val colorText = color.text.toString()
            Toast.makeText(this, "Your favourite color is $colorText", Toast.LENGTH_SHORT).show()
        }
    }
}