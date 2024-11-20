package com.example.kotlin_project

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CAPracticeBluetoothPermission : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_bluetooth_permission)
        // Check and request Bluetooth permissions
        checkBluetoothPermission()
    }

    private fun checkBluetoothPermission() {
        // Check if Bluetooth permission is granted
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Bluetooth Permission Granted", Toast.LENGTH_SHORT).show()
        } else {
            // Request Bluetooth permission if not granted
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.BLUETOOTH), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Bluetooth Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bluetooth Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}