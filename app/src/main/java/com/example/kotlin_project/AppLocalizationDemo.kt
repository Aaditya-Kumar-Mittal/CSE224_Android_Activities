package com.example.kotlin_project

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class AppLocalizationDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_localization_demo)

        var btnHindi = findViewById<Button>(R.id.toHindi)
        var btnEnglish = findViewById<Button>(R.id.toEnglish)

        btnHindi.setOnClickListener{
                setLocale("hi")
        }

        btnEnglish.setOnClickListener{
            setLocale("en")
        }

    }

    private fun setLocale(langCode: String) {
        val current = resources.configuration.locales.get(0).language
        if (langCode != current) {
            val locale = Locale(langCode)
            Locale.setDefault(locale)
            val config = Configuration(resources.configuration)
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
            recreate() // Recreate activity to apply changes
        }
    }
}