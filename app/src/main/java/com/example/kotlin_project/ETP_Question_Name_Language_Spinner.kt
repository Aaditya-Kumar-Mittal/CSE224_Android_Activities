package com.example.kotlin_project

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_Question_Name_Language_Spinner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_question_name_language_spinner)

        //Fetch the name

        val nameField = findViewById<EditText>(R.id.etpNameLanugage)
        val langSpinner = findViewById<Spinner>(R.id.etpLanguageSpinner)
        val goButton = findViewById<Button>(R.id.etpChangeToLanguage)

        val listLang = arrayOf("Japanese", "Korean", "Spanish")

        var spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listLang)

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        langSpinner.adapter = spinnerAdapter

        goButton.setOnClickListener {
            val name = nameField.text.toString()
            val lang = langSpinner.selectedItem.toString()
            if (!name.isEmpty()) {
                nameField.text.clear()
                var traslatedName = translateName(name, lang)
                Toast.makeText(this, "Your name in $lang is $traslatedName", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun translateName(name: String, lang: String): String {

        if (name == "Aaditya Kumar Mittal" && lang == "Japanese") {
            return "アーディティヤ・クマール・ミッタル"
        } else if (name == "Aaditya Kumar Mittal" && lang == "Korean") {
            return "아디티야 쿠마르 미탈"
        } else if (name == "Aaditya Kumar Mittal" && lang == "Spanish") {
            return "Aaditya Kumar Mittal"
        } else {
            return name
        }
    }
}