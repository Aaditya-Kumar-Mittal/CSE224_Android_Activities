package com.example.kotlin_project

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val toolbar : Toolbar= findViewById(R.id.profileAction)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {

                showProfileOptions()
                true
            }
            R.id.action_settings -> {

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showProfileOptions() {
        val options = arrayOf("Change Theme", "Change Password")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Profile Options")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> toggleTheme()
                1 -> changePassword()
            }
        }
        builder.show()
    }

    private fun toggleTheme() {
        val rootView = findViewById<View>(R.id.main)
        val isDarkMode = rootView.tag == "dark"
        if (isDarkMode) {
            rootView.setBackgroundColor(Color.WHITE)
            rootView.tag = "light"
        } else {
            rootView.setBackgroundColor(Color.BLACK)
            rootView.tag = "dark"
        }
    }

    private fun changePassword() {
    }
}