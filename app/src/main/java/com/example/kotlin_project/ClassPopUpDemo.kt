package com.example.kotlin_project

import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassPopUpDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_pop_up_demo)

        //Context and pop up menu automatically disappears

        var popUp = findViewById<Button>(R.id.showPopUp)

        popUp.setOnClickListener {

            val popUpMenu = PopupMenu(this, popUp)

            val m1 : MenuInflater = popUpMenu.menuInflater

            m1.inflate(R.menu.main_menu, popUpMenu.menu)

            popUpMenu.setOnMenuItemClickListener{
                item : MenuItem ->
                when(item.itemId) {
                    R.id.mmSettings -> {
                        Toast.makeText(this,"Settings Clicked!",Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.mmAbout -> {
                        Toast.makeText(this,"About Clicked!",Toast.LENGTH_SHORT).show()
                        true
                    }

                    else-> false
                }
            }
            popUpMenu.show()

        }
    }
}