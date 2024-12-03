package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_AppChooserPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_app_chooser_practice)

        var btn = findViewById<Button>(R.id.appChooserETP)

        btn.setOnClickListener {
            appChooserFunction("This text is shared using app chooser.")
        }
    }

    private fun appChooserFunction(msg: String) {

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, msg)
            type = "text/plain"
        }

        var appChooser = Intent.createChooser(intent, "Share via the apps")

        startActivity(appChooser)
    }
}