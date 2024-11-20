package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeAppChooser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_app_chooser)

        val appChooserBtn = findViewById<Button>(R.id.practiceAppChooser)

        appChooserBtn.setOnClickListener{

            shareText("This text is being shared")

        }
    }

    fun shareText(msg: String)
    {
        val intent = Intent().apply {

            action = Intent.ACTION_SEND
            
            putExtra(Intent.EXTRA_TEXT, msg)

            type = "text/plain"
        }

        val appChoose = Intent.createChooser(intent, "Share Via")

        startActivity(appChoose)
    }
}