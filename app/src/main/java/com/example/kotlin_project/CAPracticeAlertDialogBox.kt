package com.example.kotlin_project

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeAlertDialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_alert_dialog_box)

        val practiceDialog = findViewById<Button>(R.id.practiceDialog)

        practiceDialog.setOnClickListener {

            val myDialog = AlertDialog.Builder(this)

            myDialog.setTitle("Alert Dialog Practice")

            myDialog.setMessage("Do you really want to exit?")

            myDialog.setPositiveButton("Yes") { dialog, _ ->
                finish()
            }

            myDialog.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }

            myDialog.create().show()

        }

    }
}