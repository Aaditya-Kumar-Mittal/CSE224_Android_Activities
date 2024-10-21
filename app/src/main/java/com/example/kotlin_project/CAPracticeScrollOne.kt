package com.example.kotlin_project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeScrollOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_scroll_one)

        //Scroll View can only have one direct child placed within it
        //A view hierarchy that allows the view to be scrolled
        //Vertical scrolling and horizontal scrolling
    }
}