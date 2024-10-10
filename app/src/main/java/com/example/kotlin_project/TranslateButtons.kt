package com.example.kotlin_project

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class TranslateButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_translate_buttons)

        val hindiBtn = findViewById<Button>(R.id.hindiBtn)
        val englishBtn = findViewById<Button>(R.id.englishBtn)

        hindiBtn.setOnClickListener{
            setLocale("hi")
        }

        englishBtn.setOnClickListener{
            setLocale("en")
        }

    }

    private fun setLocale(langCode : String){
        //Run code when current language is different than the current set language

        val getCurrentLanguage = resources.configuration.locales.get(0).language //gets current language of the current system

        if(langCode != getCurrentLanguage)
        {
            val locale = Locale(langCode)

            Locale.setDefault(locale)

            val config = Configuration(resources.configuration) //Update the configuration

            config.setLocale(locale)

            resources.updateConfiguration(config, resources.displayMetrics)
        }

        recreate()
    }
}