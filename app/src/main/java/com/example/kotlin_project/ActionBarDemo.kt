package com.example.kotlin_project

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActionBarDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_action_bar_demo)

        //if room is available in fragments if space display and never displays
        //never actually is never used by default, it used in Kotlin. initially never visible and later on action make it visible
        //menu are inflated they are not widgets

        //toolbar will be used as action bar
        var toolAction: Toolbar = findViewById(R.id.toolbarAction)
        //Toolbar is of widget and appCompact.widget

        setSupportActionBar(toolAction)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.mmAbout ->{
                Toast.makeText(this,"Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.mmSettings->{
                Toast.makeText(this,"Settings Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
}
