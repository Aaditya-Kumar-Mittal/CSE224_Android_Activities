package com.example.kotlin_project

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_ReceiveDataPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_receive_data_practice)

        //fetch text view

        val userV = findViewById<TextView>(R.id.receiverUserNameETP)
        val passV = findViewById<TextView>(R.id.receivePasswordETP)

        val userText = intent.getStringExtra("USER_NAME_ETP")
        val pasText = intent.getStringExtra("PASS_WORD_ETP")

        userV.text = userText
        passV.text = pasText

    }
}