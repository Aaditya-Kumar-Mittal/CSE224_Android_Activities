package com.example.kotlin_project

import android.content.Intent
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

class CAPracticeContextMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_context_menu)

        val practiceContext = findViewById<ImageView>(R.id.practiceContext)

        registerForContextMenu(practiceContext)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val getMenu: MenuInflater = menuInflater

        getMenu.inflate(R.menu.practice_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val practiceContext = findViewById<ImageView>(R.id.practiceContext)

        return when (item.itemId) {

            R.id.practiceChangeColor -> {
                practiceContext.setColorFilter(Color.BLUE)
                Toast.makeText(this, "Image color changed to blue", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.practiceRotate -> {
                practiceContext.rotation = practiceContext.rotation + 45f
                Toast.makeText(this, "Image rotated by 45 degrees", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.practiceChangeBack -> {
                practiceContext.colorFilter = null
                Toast.makeText(this, "Image color changed back to original", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.practiceShareImage -> {
                shareText("Image shared successfully")
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    fun shareText(msg: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, msg)
            type = "text/plain"
        }

        val appChoose = Intent.createChooser(intent, "Share Via")

        startActivity(appChoose)
    }
}