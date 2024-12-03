package com.example.kotlin_project

import android.graphics.Color
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_PopUpMenuPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_pop_up_menu_practice)

        val image = findViewById<ImageView>(R.id.popupImageETP)

        image.setOnClickListener {

            val popUp = PopupMenu(this, image)

            val menuInflate: MenuInflater = popUp.menuInflater

            menuInflate.inflate(R.menu.etp_practice_context_popup, popUp.menu)

            popUp.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.etpColorBlue -> {
                        image.setColorFilter(Color.BLUE)
                        true
                    }

                    R.id.etpColorOriginal -> {
                        image.colorFilter = null
                        true
                    }

                    R.id.etpRotate -> {
                        image.rotation = image.rotation + 45f
                        true
                    }

                    R.id.etpShareImage -> {
                        Toast.makeText(this, "Image shared successfully", Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false

                }
            }

            popUp.show()
        }
    }
}