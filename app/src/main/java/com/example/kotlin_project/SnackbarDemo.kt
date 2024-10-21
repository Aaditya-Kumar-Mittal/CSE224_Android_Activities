package com.example.kotlin_project

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SnackbarDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snackbar_demo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val snackBtn = findViewById<Button>(R.id.snackBtn)

        //1. Create a snackbar snackbar.make -> context, message, duration
        //2. Snackbar.setAction() -> 2 parameters -> what to display and what to do
        //3.
        //4. Swiping of snackbar is a feature in Android only in latest features
        //5.

        snackBtn.setOnClickListener{

            //Snackbar.make(it, "Snackbar displayed successfully!", Snackbar.LENGTH_LONG).setAction("Don't Show"){}.show()

            view -> Snackbar.make(view, "Snackbar displayed successfully!", Snackbar.LENGTH_INDEFINITE).setAction("Don't Show"){}.show()

            //find a way to find out how to swipe the snackbar -> CoordinationLayout and FrameLayout
            //make it disappear after 10 seconds


        }

    }
}