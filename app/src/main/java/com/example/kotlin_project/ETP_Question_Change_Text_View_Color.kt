package com.example.kotlin_project

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_Question_Change_Text_View_Color : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_question_change_text_view_color)

        val btn = findViewById<Button>(R.id.etpChangeTextViewColors1)
        val tV1 = findViewById<TextView>(R.id.textView22)
        val tV2 = findViewById<TextView>(R.id.textView23)
        val tV3 = findViewById<TextView>(R.id.textView24)

        btn.setOnClickListener {
            tV1.setBackgroundColor(Color.RED)
            tV2.setBackgroundColor(Color.GREEN)
            tV3.setBackgroundColor(Color.BLUE)
        }
    }
}