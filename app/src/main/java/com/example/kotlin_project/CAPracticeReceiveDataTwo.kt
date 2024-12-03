package com.example.kotlin_project

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class CAPracticeReceiveDataTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_receive_data_two)

        val rU = findViewById<TextView>(R.id.receiveUserName1)
        val rP = findViewById<TextView>(R.id.receivePassword1)

        val user = intent.getStringExtra("USER_NAME")
        val pass = intent.getStringExtra("PASS_WORD")

        rU.text = user
        rP.text = pass
    }
}