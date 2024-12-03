package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_CheckBoxPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_check_box_practice)

        val submit = findViewById<Button>(R.id.etpCheckButton)
        val c1 = findViewById<CheckBox>(R.id.etpCheck1)
        val c2 = findViewById<CheckBox>(R.id.etpCheck2)
        val c3 = findViewById<CheckBox>(R.id.etpCheck3)

        submit.setOnClickListener {

            if (c1.isChecked && c2.isChecked && c3.isChecked) {
                Toast.makeText(this, "All checkboxes are checked", Toast.LENGTH_SHORT).show()
            } else if (c1.isChecked && c2.isChecked && !c3.isChecked) {
                Toast.makeText(this, c1.text.toString() + " and " + c2.text.toString(), Toast.LENGTH_SHORT).show()
            } else if (c1.isChecked && !c2.isChecked && c3.isChecked) {
                Toast.makeText(this, c1.text.toString() + " and " + c3.text.toString(), Toast.LENGTH_SHORT).show()
            } else if (!c1.isChecked && c2.isChecked && c3.isChecked) {
                Toast.makeText(this, c2.text.toString() + " and " + c3.text.toString(), Toast.LENGTH_SHORT).show()
            } else if (c1.isChecked && !c2.isChecked && !c3.isChecked) {
                Toast.makeText(this, c1.text.toString(), Toast.LENGTH_SHORT).show()
            } else if (!c1.isChecked && c2.isChecked && !c3.isChecked) {
                Toast.makeText(this, c2.text.toString(), Toast.LENGTH_SHORT).show()
            } else if (!c1.isChecked && !c2.isChecked && c3.isChecked) {
                Toast.makeText(this, c3.text.toString(), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No checkboxes are checked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}