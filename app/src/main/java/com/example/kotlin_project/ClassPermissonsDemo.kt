package com.example.kotlin_project

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassPermissonsDemo : AppCompatActivity() {

    val c = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_permissons_demo)

        var perBtn = findViewById<Button>(R.id.buttonPerms)

        //In production, the code for the permissions in the starting and not in some button listener

        perBtn.setOnClickListener{

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.BLUETOOTH,android.Manifest.permission.ACCESS_WIFI_STATE ), c)
            }
            else{
                Toast.makeText(applicationContext, "Permission has already been granted.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}