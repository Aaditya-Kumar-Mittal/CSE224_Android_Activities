package com.example.kotlin_project

import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassRatingBarDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_rating_bar_demo)

        val rbRatingBar = findViewById<RatingBar>(R.id.ratingBar)

        // Set initial rating and step size
        rbRatingBar.rating = 3.5f
        rbRatingBar.stepSize = 0.5f

        // Set up RatingBar change listener
        rbRatingBar.setOnRatingBarChangeListener { _, rating, _ ->
            // Show Toast with the rating value
            Toast.makeText(this, "Rating: $rating", Toast.LENGTH_SHORT).show()
        }

    }
}