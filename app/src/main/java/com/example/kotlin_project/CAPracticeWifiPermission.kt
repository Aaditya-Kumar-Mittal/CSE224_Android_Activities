package com.example.kotlin_project

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAPracticeWifiPermission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_wifi_permission)

        // Check Wi-Fi permission on startup
        checkWifiPermission()
    }

    private fun checkWifiPermission() {
        // Check if Wi-Fi permission is granted
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_WIFI_STATE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Wi-Fi Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            // Request Wi-Fi permission if not granted
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_WIFI_STATE), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Wi-Fi Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wi-Fi Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}