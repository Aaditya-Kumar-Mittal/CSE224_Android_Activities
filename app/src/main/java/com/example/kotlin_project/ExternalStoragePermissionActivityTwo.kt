package com.example.kotlin_project

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ExternalStoragePermissionActivityTwo : AppCompatActivity() {

    private val STORAGE_PERMISSION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage_permission_two)

        val permissionButton = findViewById<Button>(R.id.permissionButton1)
        permissionButton.setOnClickListener {
            // Check if permission is granted
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                // Direct the user to settings to manually grant permission
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                startActivityForResult(intent, STORAGE_PERMISSION_REQUEST_CODE)
            } else {
                // Permission is already granted, proceed with external storage operations
                accessExternalStorage()
            }
        }
    }

    private fun accessExternalStorage() {
        // Your code to interact with external storage goes here
        Toast.makeText(this, "Accessing External Storage", Toast.LENGTH_SHORT).show()
    }

    // Handle the result after the user returns from settings
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            // Check if permission has been granted after returning from settings
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.MANAGE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show()
                accessExternalStorage()
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
