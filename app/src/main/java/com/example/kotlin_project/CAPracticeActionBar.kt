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

class CAPracticeActionBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_action_bar)

        //Create an object of Toolbar Type
        val practiceToolbar : Toolbar = findViewById(R.id.practiceToolbar)
        setSupportActionBar(practiceToolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.practice_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.snackOption ->
            {
                Toast.makeText(applicationContext, "Snackbar Option", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.spinnerOption ->
            {
                Toast.makeText(applicationContext, "Spinner Option", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.implicitOption->
            {
                Toast.makeText(applicationContext, "Implicit Option", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.explicitOption ->
            {
                Toast.makeText(applicationContext, "Explicit Option", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.scrollOption ->
            {
                Toast.makeText(applicationContext, "Scroll Option", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.listOption ->
            {
                Toast.makeText(applicationContext, "List Option", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.appLocalOption->{
                Toast.makeText(applicationContext, "App Localization Option", Toast.LENGTH_SHORT).show()
                true
            }
            else ->super.onOptionsItemSelected(item)
        }
    }
}