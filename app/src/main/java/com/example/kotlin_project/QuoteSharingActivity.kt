package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuoteSharingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quote_sharing)

        var q1 = findViewById<CardView>(R.id.quoteOne)
        var q2 = findViewById<CardView>(R.id.quoteTwo)
        var q3 = findViewById<CardView>(R.id.quoteThree)
        var q4 = findViewById<CardView>(R.id.quoteFour)
        var q5 = findViewById<CardView>(R.id.quoteFive)
        var q6 = findViewById<CardView>(R.id.quoteSix)

        //Portfolio App Permissions -> Camera, Wifi, Bluetooth, Contacts

        q1.setOnClickListener{

            var quote1 = findViewById<TextView>(R.id.quoteOneText)

            shareText(quote1.text.toString())
        }

        q2.setOnClickListener{

            var quote2 = findViewById<TextView>(R.id.quoteTwoText)

            shareText(quote2.text.toString())
        }

        q3.setOnClickListener{

            var quote3 = findViewById<TextView>(R.id.quoteThreeText)

            shareText(quote3.text.toString())
        }

        q4.setOnClickListener{

            var quote4 = findViewById<TextView>(R.id.quoteFourText)

            shareText(quote4.text.toString())
        }

        q5.setOnClickListener{

            var quote5 = findViewById<TextView>(R.id.quoteFiveText)

            shareText(quote5.text.toString())
        }

        q6.setOnClickListener{

            var quote6 = findViewById<TextView>(R.id.quoteSixText)

            shareText(quote6.text.toString())
        }

    }

    fun shareText(msg: String) {

        var intent = Intent().apply {

            action = Intent.ACTION_SEND

            putExtra(Intent.EXTRA_TEXT, msg)

            //type
            type = "text/plain"
        }

        var i = Intent.createChooser(intent, "Share Via")

        startActivity(i)
    }
}