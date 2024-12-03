package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class ETP_SnackbarPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_snackbar_practice)

        val snackBtn = findViewById<Button>(R.id.snackbarETP)

        snackBtn.setOnClickListener {
                view -> Snackbar.make(view, "Snackbar displayed successfully!", Snackbar.LENGTH_INDEFINITE).setAction("Don't Show") {}.show()
        }

    }
}