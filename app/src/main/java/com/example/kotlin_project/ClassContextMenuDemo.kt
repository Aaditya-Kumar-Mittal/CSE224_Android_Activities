package com.example.kotlin_project

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassContextMenuDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_context_menu_demo)

        //Context menu are inflated by long press

        var j1 = findViewById<ImageView>(R.id.contextMenu)

        registerForContextMenu(j1)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {

        super.onCreateContextMenu(menu, v, menuInfo)

        val j2: MenuInflater = menuInflater

        j2.inflate(R.menu.context_demo, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var j1 = findViewById<ImageView>(R.id.contextMenu)

        return when (item.itemId) {
            R.id.change_color -> {

                j1.setColorFilter(Color.RED)
                Toast.makeText(this, "Image color changed to red", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.rotateImg -> {
                j1.rotation= j1.rotation +45f
                Toast.makeText(this, "Image rotated by 45 degrees", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.changeBack -> {
                j1.setColorFilter(null)
                Toast.makeText(this, "Image color changed back to original", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}