package com.example.kotlin_project

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ETP_Question_Profile_Backgrounding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_question_profile_backgrounding)
        val toolbar: Toolbar = findViewById(R.id.etpProfileAction)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.etp_profile_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.etpShowProfile -> {
                showProfilePopUp(findViewById(R.id.etpShowProfile))
                true
            }

            R.id.etpShowSettings -> {
                startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
                true
            }

            else -> false
        }
    }

    private fun showProfilePopUp(anchor: View) {
        val popUpMenu = PopupMenu(this, anchor)

        var menuInflate: MenuInflater = popUpMenu.menuInflater

        menuInflate.inflate(R.menu.etp_profile_popup, popUpMenu.menu)

        popUpMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.etpChangeTheme -> {
                    changeTheme()
                    true
                }

                R.id.etpChangePassword -> {
                    changePassword()
                    true
                }

                else -> false
            }
        }

        popUpMenu.show()
    }

    private fun changePassword() {
        Toast.makeText(this, "Change Password clicked", Toast.LENGTH_SHORT).show()
    }

    private fun changeTheme() {

        var rootView = findViewById<View>(R.id.main)

        var isDark = rootView.tag == "dark"

        if (isDark) {
            rootView.setBackgroundColor(Color.WHITE)
            rootView.tag = "light"
        } else {
            rootView.setBackgroundColor(Color.BLACK)
            rootView.tag = "dark"
        }

    }

}