package com.example.kotlin_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_Question_Caller : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_question_caller)

        val name = findViewById<EditText>(R.id.questionName)
        val number = findViewById<EditText>(R.id.questionNumber)
        val btn = findViewById<Button>(R.id.questionCall)

        btn.setOnClickListener {

            val nameText = name.text.toString()
            val numberText = number.text.toString()

            if (!nameText.isEmpty() && !numberText.isEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:$numberText"))
                Toast.makeText(this, "Calling $nameText", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter your name and number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}