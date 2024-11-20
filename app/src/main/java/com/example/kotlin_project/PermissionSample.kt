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

class PermissionSample : AppCompatActivity() {

    val CAMERA_PERMISSION_CODE = 1
    val STORAGE_PERMISSION_CODE = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_permission_sample)

        val cameraButton = findViewById<Button>(
            R.id.btnCameraPermission
        )
        val storageButton = findViewById<Button>(R.id.btnStoragePermission)

        cameraButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
                )
            } else {
                Toast.makeText(this, "Camera permission already granted", Toast.LENGTH_SHORT).show()
            }
        }

        storageButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ),
                    STORAGE_PERMISSION_CODE
                )
            } else {
                Toast.makeText(this, "Storage permissions already granted", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
                }
            }

            STORAGE_PERMISSION_CODE -> {
                if (grantResults.size >= 2 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(this, "Storage permissions granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Storage permissions denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

//Correct the code for external storage