package com.example.kotlin_project

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeCustomAlertDialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_custom_alert_dialog_box)

        val practiceCustomDialog = findViewById<Button>(R.id.practiceCustomDialog)

        practiceCustomDialog.setOnClickListener {

            val dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_practice, null)

            val myDialog = AlertDialog.Builder(this).setView(dialogView)

            myDialog.setPositiveButton("Subscribe") { dialog, _ ->

                val email = dialogView.findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()

                if (email.isNotEmpty()) {
                    Toast.makeText(this, "Email is $email", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                }
            }

            myDialog.setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }

            myDialog.create().show()
        }
    }
}