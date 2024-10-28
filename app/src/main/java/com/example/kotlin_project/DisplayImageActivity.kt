package com.example.kotlin_project

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_image)

        val imageView = findViewById<ImageView>(R.id.imageView)

        // Retrieve the bitmap from the intent
        val imageBitmap = intent.extras?.get("imageBitmap") as Bitmap
        imageView.setImageBitmap(imageBitmap)
    }
}