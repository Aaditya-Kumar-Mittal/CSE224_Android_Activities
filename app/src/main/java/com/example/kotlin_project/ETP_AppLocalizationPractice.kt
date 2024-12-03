package com.example.kotlin_project

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class ETP_AppLocalizationPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_app_localization_practice)

        //fetch all language buttons
        var hindi = findViewById<Button>(R.id.hindiETP)
        var english = findViewById<Button>(R.id.englisETP)
        var sanskrit = findViewById<Button>(R.id.sanskritETP)

        hindi.setOnClickListener { setLanguage("hi") }
        english.setOnClickListener { setLanguage("en") }
        sanskrit.setOnClickListener { setLanguage("sa") }
    }

    private fun setLanguage(langCode: String) {

        //Get status of current language code

        val currentCode = resources.configuration.locales.get(0).language

        if (currentCode != langCode) {
            val locale = Locale(langCode)

            Locale.setDefault(locale)

            val config = Configuration(resources.configuration)

            config.setLocale(locale)

            resources.updateConfiguration(config, resources.displayMetrics)

            Log.i("Language Changed", "Language changed to : $langCode")

            recreate()
        }
    }
}