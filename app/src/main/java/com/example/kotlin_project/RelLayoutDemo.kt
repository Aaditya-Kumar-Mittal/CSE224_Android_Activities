package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RelLayoutDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rel_layout_demo)

        val likeBtn = findViewById<Button>(R.id.likeButton)
        val commentBtn = findViewById<Button>(R.id.commentButton)

        likeBtn.setOnClickListener {
            val like = Toast.makeText(this, "You liked this profile!", Toast.LENGTH_SHORT)
            like.show()
        }


    }
}