package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_screen)

        val btn = findViewById<Button>(R.id.signIn)
        val input = findViewById<EditText>(R.id.userId)

        btn.setOnClickListener{

            var text = input.text.toString()

            Toast.makeText(this,"Welcome Back",Toast.LENGTH_SHORT).show()
        }
    }
}