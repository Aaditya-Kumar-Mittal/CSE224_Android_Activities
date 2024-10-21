package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeDataPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_data_pass)

        val passInput = findViewById<Button>(R.id.practiceButton1)
        val takeInput = findViewById<EditText>(R.id.practiceInput1)

        passInput.setOnClickListener{
            val message = takeInput.text.toString()

            val intent = Intent(applicationContext, CAPracticeReceiveData::class.java).also {
                it.putExtra("EXTRA_MESSAGE", message)
                startActivity(it)
            }
        }
    }
}