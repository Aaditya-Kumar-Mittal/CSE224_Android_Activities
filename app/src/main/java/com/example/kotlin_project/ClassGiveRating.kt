package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassGiveRating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_give_rating)

        val giveRating = findViewById<Button>(R.id.giveRating)

        giveRating.setOnClickListener{

            //Create a alert dialog box
            var b = AlertDialog.Builder(this)

            b.setTitle("Rate Us")
            b.setMessage("How was Your Experience?")

            // b.setCancelable(false)
            b.setCancelable(true)

            //If set false -> dialog box won't disappear

            b.setPositiveButton("Yes") { dialog, _ ->
                var intent = Intent(this, ClassRatingBarDemo::class.java)
                startActivity(intent)
            }

            b.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            b.setNeutralButton("Maybe") { dialog, _ ->
                Toast.makeText(this, "Clicked on Neutral Button", Toast.LENGTH_SHORT).show()
            }

            b.create().show()
        }
    }
}