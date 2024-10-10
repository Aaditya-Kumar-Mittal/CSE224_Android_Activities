package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntentScreenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_screen_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //When the destination activity is known is called the explicit intent - shifting within the application but only when in the codebase the destination has been mentioned then it is explicit
        //When the destination screen is not known and the action is known is called the Implicit intent - if the destination is not given

        var btn = findViewById<Button>(R.id.singUp)

        var data = findViewById<EditText>(R.id.dataIntent)

        btn.setOnClickListener{

            var store = data.text.toString()

            var myIntent = Intent(this, IntentScreenTwo::class.java)

            myIntent.putExtra("myData",store)

            startActivity(myIntent)

        }
    }
}