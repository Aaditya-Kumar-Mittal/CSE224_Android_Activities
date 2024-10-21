package com.example.kotlin_project

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeReceiveData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_receive_data)

        val fetchMessage = intent.getStringExtra("EXTRA_MESSAGE")

        val displayMessage = findViewById<TextView>(R.id.receiverData1).apply {
            text = fetchMessage
        }
    }
}