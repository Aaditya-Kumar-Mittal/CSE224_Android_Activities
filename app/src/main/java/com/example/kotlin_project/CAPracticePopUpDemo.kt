package com.example.kotlin_project

import android.graphics.Color
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticePopUpDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_pop_up_demo)

        val image = findViewById<ImageView>(R.id.practicePopUp)

        image.setOnClickListener {

            //Create the pop up menu
            val popUpMenu = PopupMenu(this, image)

            //Inflate the menu
            val menuInflate: MenuInflater = popUpMenu.menuInflater

            //Attach the menu
            menuInflate.inflate(R.menu.popup_demo, popUpMenu.menu)

            popUpMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {

                    R.id.practiceChangeColorPopUp -> {
                        image.setColorFilter(Color.BLUE)
                        true
                    }

                    R.id.practiceChangeSize -> {
                        image.scaleX = 2f
                        image.scaleY = 2f
                        true
                    }

                    R.id.practiceChangeBackPopUp -> {
                        image.colorFilter = null
                        true
                    }

                    R.id.practiceRotatePopUp -> {
                        image.rotation = image.rotation + 90f
                        true
                    }

                    else -> false
                }
            }

            //Show the pop up menu
            popUpMenu.show()

        }
    }
}