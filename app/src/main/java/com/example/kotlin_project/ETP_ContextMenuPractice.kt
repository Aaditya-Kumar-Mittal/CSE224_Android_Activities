package com.example.kotlin_project

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_ContextMenuPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_context_menu_practice)
        val img = findViewById<ImageView>(R.id.contextTestETP)
        registerForContextMenu(img)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.etp_practice_context_popup, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        val img = findViewById<ImageView>(R.id.contextTestETP)

        return when (item.itemId) {

            R.id.etpColorBlue -> {
                var myDialog = AlertDialog.Builder(this).setTitle("Color Blue").setMessage("Do you want to change the color to blue?")
                myDialog.setPositiveButton("Yes") { dialog, _ ->

                    img.setColorFilter(Color.BLUE)
                    Toast.makeText(this, "Image color changed to blue", Toast.LENGTH_SHORT).show()
                }
                myDialog.setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }
                myDialog.show()
                true
            }

            R.id.etpColorOriginal -> {
                var myDialog = AlertDialog.Builder(this).setTitle("Change Back To Original").setMessage("Do you want to change it back to original?")
                myDialog.setPositiveButton("Yes") { dialog, _ ->

                    img.colorFilter = null
                    Toast.makeText(this, "Image color changed to blue", Toast.LENGTH_SHORT).show()
                }
                myDialog.setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }
                myDialog.show()
                true
            }

            R.id.etpShareImage -> {
                var myDialog = AlertDialog.Builder(this).setTitle("Share Image").setMessage("Do you want to share image?")
                myDialog.setPositiveButton("Yes") { dialog, _ ->
                    val intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Image shared successfully")
                        type = "text/plain"
                    }
                    val appChoose = Intent.createChooser(intent, "Share Via")
                    startActivity(appChoose)
                }
                myDialog.setNegativeButton("No") { dialog, _ ->
                    dialog.cancel()
                }
                myDialog.show()
                true
            }

            R.id.etpRotate -> {
                img.rotation = img.rotation + 45f
                Toast.makeText(this, "Image rotated by 45 degrees", Toast.LENGTH_SHORT).show()
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}