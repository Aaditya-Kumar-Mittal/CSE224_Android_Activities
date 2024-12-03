package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_AlertDialogPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_alert_dialog_practice)

        var dialogBtn = findViewById<Button>(R.id.dialogETP1)

        dialogBtn.setOnClickListener {

            var myDialog = AlertDialog.Builder(this).setTitle("ETP Dialog Box").setMessage("ETP Dialog Box Practice")

            myDialog.setPositiveButton("Yes") { dialog, _ -> Toast.makeText(this, "Yes Button Clicked", Toast.LENGTH_SHORT).show() }

            myDialog.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }

            myDialog.create().show()
        }
    }
}