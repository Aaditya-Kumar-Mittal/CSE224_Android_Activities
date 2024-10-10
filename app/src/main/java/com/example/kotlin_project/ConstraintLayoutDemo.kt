package com.example.kotlin_project

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConstraintLayoutDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint_layout_demo)

        // There is no nesting in constraint layout
        // Cannot drag and drop in constraint layout
        // Left means start
        // Right means end
        // Top means top
        // Bottom means Bottom
        //Constraint binding layout
        //One side binding is compulsory




    }
}