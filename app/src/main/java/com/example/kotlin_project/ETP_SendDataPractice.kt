package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_SendDataPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_send_data_practice)

        //Fetch input and button
        val user = findViewById<EditText>(R.id.enterUsernameETP)
        val pass = findViewById<EditText>(R.id.enterPasswordETP)
        val send = findViewById<Button>(R.id.sendDataETP)

        send.setOnClickListener {

            //Fetch input data

            val username = user.text.toString()
            val password = pass.text.toString()

            //Create intent to send data
            val intent = Intent(this, ETP_ReceiveDataPractice::class.java).also {
                it.putExtra("USER_NAME_ETP", username)
                it.putExtra("PASS_WORD_ETP", password)
            }
            startActivity(intent)
        }
    }
}