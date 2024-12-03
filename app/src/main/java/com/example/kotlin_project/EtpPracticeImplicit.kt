package com.example.kotlin_project

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EtpPracticeImplicit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_practice_implicit)

        //Get all buttons
        val google = findViewById<Button>(R.id.googleButtonETP)
        val camera = findViewById<Button>(R.id.cameraButtonETP)
        val gallery = findViewById<Button>(R.id.galleryButtonETP)
        val dialer = findViewById<Button>(R.id.dialerButtonETP)
        val contacts = findViewById<Button>(R.id.contactsButtonETP)
        val calendar = findViewById<Button>(R.id.calendarButtonETP)

        //Implicit Intent
        google.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }

        camera.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        gallery.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivity(intent)
        }

        dialer.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:123456789"))
            startActivity(intent)
        }

        contacts.setOnClickListener {
            var intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }

        calendar.setOnClickListener {
            var intent = Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_APP_CALENDAR)
            }
            startActivity(intent)
        }
    }
}