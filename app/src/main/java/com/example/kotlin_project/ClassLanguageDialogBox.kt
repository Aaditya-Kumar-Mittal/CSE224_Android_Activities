package com.example.kotlin_project

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassLanguageDialogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_language_dialog_box)

        val showDialogButton: Button = findViewById(R.id.showDialogButton)

        showDialogButton.setOnClickListener {
            showLanguageDialog()
        }
    }

    private fun showLanguageDialog() {
        // Inflate the custom dialog layout
        val inflater = LayoutInflater.from(this)
        val dialogView = inflater.inflate(R.layout.dialog_language_list, null)

        val languageListView: ListView = dialogView.findViewById(R.id.languageListView)

        // List of languages
        val languages = arrayOf("English", "Spanish", "French", "German", "Chinese", "Japanese")

        // Set up adapter for ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)

        languageListView.adapter = adapter

        // Create and show the dialog
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        dialog.show()

        // Handle item clicks
        languageListView.setOnItemClickListener { _, _, position, _ ->
            val selectedLanguage = languages[position]
            Toast.makeText(this, "Selected: $selectedLanguage", Toast.LENGTH_SHORT).show()
            dialog.dismiss() // Close dialog after selection
        }
    }
}