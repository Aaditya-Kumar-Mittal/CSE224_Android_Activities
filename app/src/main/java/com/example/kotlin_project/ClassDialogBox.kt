package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_dialog_box)

        var dialogBtn = findViewById<Button>(R.id.dialogDemo)

        dialogBtn.setOnClickListener {

            //Message, Negative Button, Positive Button
            //Since not customizing it, AlertDialog is also an in-built class

            //Create a alert dialog box
            var b = AlertDialog.Builder(this)

            b.setTitle("Dialog Box Demo")
            b.setMessage("Do you really want to exit?")

            // b.setCancelable(false)
            b.setCancelable(true)

            //If set false -> dialog box won't disappear

            b.setPositiveButton("Yes") { dialog, _ ->
                finish()
            }

            b.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            b.setNeutralButton("Dekho Bhai") { dialog, _ ->
                Toast.makeText(this, "Clicked on Neutral Button", Toast.LENGTH_SHORT).show()
            }

            b.create().show()
        }
    }
}