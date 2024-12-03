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

class ExternalStoragePermissionActivity : AppCompatActivity() {

    private val STORAGE_PERMISSION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_storage_permission)

        val permissionButton = findViewById<Button>(R.id.permissionButton)
        permissionButton.setOnClickListener {
            // Check if permission is granted
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
            ) {

                // Request permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    STORAGE_PERMISSION_REQUEST_CODE
                )
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

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED
            ) {

                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show()
                accessExternalStorage()
            } else {
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}