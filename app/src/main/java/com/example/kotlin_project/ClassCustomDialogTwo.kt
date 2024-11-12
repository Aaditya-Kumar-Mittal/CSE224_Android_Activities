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

class ClassCustomDialogTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_custom_dialog_two)

        val custom = findViewById<Button>(R.id.customDialogTwo)

        custom.setOnClickListener{

            val  dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_two, null)

            val b = AlertDialog.Builder(this).setView(dialogView)

            b.setPositiveButton("Subscribe!"){

                dialog, _ ->

                val emailField = dialogView.findViewById<EditText>(R.id.editTextEnterEmail)

                val emailText = emailField.text.toString()

                if (emailText.isNotEmpty())
                {
                    Toast.makeText(this, "Subscribed with: $emailText",Toast.LENGTH_SHORT).show()
                }
                else{
                   Toast.makeText(this, "Please enter some email",Toast.LENGTH_SHORT).show()
                }

                dialog.dismiss()
            }

            b.setNegativeButton("Cancel"){dialog, _ -> dialog.dismiss()}

            b.create().show()

        }

        //Try to set Alarm
        //Try Rating Bar in Dialog Box   Button set Reminder and a button to add reminder and on click dialog box should open and it should have okay and cancel, okay sets the alarm and toast is displayed


    }
}