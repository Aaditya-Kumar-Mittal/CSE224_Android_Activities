package com.example.kotlin_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_ImplicitIntentPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_implicit_intent_practice)

        //Fetch all intent
        val googleCard = findViewById<CardView>(R.id.googleETP)
        val cameraCard = findViewById<CardView>(R.id.cameraETP)
        val contactsCard = findViewById<CardView>(R.id.contactsETP)
        val logsCard = findViewById<CardView>(R.id.logsETP)
        val galleryCard = findViewById<CardView>(R.id.galeryETP)
        val dialerCard = findViewById<CardView>(R.id.dialerETP)

        googleCard.setOnClickListener {
            var url = "https://www.google.com"
            intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}