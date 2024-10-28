package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassAppChooserDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_app_chooser_demo)

        var chooseButton = findViewById<Button>(R.id.chooseBtn)

        chooseButton.setOnClickListener{

            shareText("This text is being shared")

        }

    }

    fun shareText(msg: String) {

        var intent = Intent().apply {

            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_TEXT, msg)

            //type
            type = "text/plain"
        }

        var i = Intent.createChooser(intent, "Share Via")

        startActivity(i)
    }
}