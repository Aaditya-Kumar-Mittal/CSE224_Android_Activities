package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeSendData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_send_data)

        val inputUserName = findViewById<EditText>(R.id.inputUserName1)
        val inputPassword = findViewById<EditText>(R.id.inputPassword1)
        val sendMyData = findViewById<Button>(R.id.sendUserPass1)

        sendMyData.setOnClickListener {

            val userName = inputUserName.text.toString()
            val passWord = inputPassword.text.toString()

            val intent = Intent(this, CAPracticeReceiveDataTwo::class.java).also {
                it.putExtra("USER_NAME", userName)
                it.putExtra("PASS_WORD", passWord)
            }

            startActivity(
                intent
            )
        }

    }
}