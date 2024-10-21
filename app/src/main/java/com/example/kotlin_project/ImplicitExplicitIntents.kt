package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitExplicitIntents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_explicit_intents)

        val urlBtn = findViewById<Button>(R.id.urlButton)
        val navigateBtn = findViewById<Button>(R.id.navButton)
        val cameraBtn = findViewById<Button>(R.id.cameraButton)
        val callBtn = findViewById<Button>(R.id.callButton)
        val contactBtn = findViewById<Button>(R.id.contactButton)
        val galleryBtn = findViewById<Button>(R.id.galleryButton)

        //CA-2 Next Tuesday Uit-3 and Unit-4
        //Activity must be done by Monday for extra marks in the CA-2 -> Portfolio app, App bar, more aesthetic and professional, best 6
        //Verbose log -> most detailed information about the application in Log
        //Warning logs ->
        //Information Log ->
        //Debug log ->

    }
}