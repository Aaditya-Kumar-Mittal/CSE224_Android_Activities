package com.example.kotlin_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeIntents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_intents)

        //Implicit Intent
        var googleIt = findViewById<Button>(R.id.googleBtn)
        var captureImg = findViewById<Button>(R.id.capturImage)
        var contactBtn = findViewById<Button>(R.id.contacts)
        var galleryBt = findViewById<Button>(R.id.galleryBtn)
        var callLogsBtn = findViewById<Button>(R.id.callLog)
        var dialerBtn = findViewById<Button>(R.id.dialerButton)

        var url = "https://www.google.com"

        googleIt.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        captureImg.setOnClickListener {
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        callLogsBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setType(CallLog.Calls.CONTENT_TYPE)
            startActivity(intent)
        }

        contactBtn.setOnClickListener {
            var i5 = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(i5)
        }

        galleryBt.setOnClickListener {
            var i6 = Intent()
            i6.action = Intent.ACTION_PICK
            i6.type = "image/*"
            startActivity(i6)
        }

        dialerBtn.setOnClickListener {
            var dialMe = Intent(Intent.ACTION_DIAL)
            dialMe.setData(Uri.parse("tel:+91123456789"))
            startActivity(dialMe)
        }

    }
}