package com.example.kotlin_project

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntentScreenTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_screen_two)

        var textV = findViewById<TextView>(R.id.textView7)

        //Receiving the data

        var receivedData = intent.getStringExtra("myData")

        textV.text = receivedData


    }
}