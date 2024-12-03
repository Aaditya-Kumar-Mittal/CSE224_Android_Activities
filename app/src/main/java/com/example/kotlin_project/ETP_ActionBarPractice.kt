package com.example.kotlin_project

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_ActionBarPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_action_bar_practice)

        //Fetch toolbar widget
        val toolbar: Toolbar = findViewById(R.id.toolbarETP)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.etp_practice_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.cameraOptionETP -> {
                startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                true
            }

            R.id.settingsOptionETP -> {
                startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}