package com.example.kotlin_project

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
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

class ETP_BluetoothPermissionPractice : AppCompatActivity() {

    private val BLUETOOTH_PERMISSION_REQUEST_CODE = 1
    private val BLUETOOTH_ENABLE_REQUEST_CODE = 2
    private lateinit var bluetoothAdapter: BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etp_bluetooth_permission_practice)

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        val bluetoothPermissionButton = findViewById<Button>(R.id.bluetoothPermissionETP)
        bluetoothPermissionButton.setOnClickListener {
            // Check for Bluetooth permissions
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_DENIED ||
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.BLUETOOTH_SCAN, android.Manifest.permission.BLUETOOTH_CONNECT),
                    BLUETOOTH_PERMISSION_REQUEST_CODE
                )
            } else {
                enableBluetooth()
            }
        }
    }

    // Enable Bluetooth if it's not already enabled
    private fun enableBluetooth() {
        if (!bluetoothAdapter.isEnabled) {
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            startActivityForResult(enableBtIntent, BLUETOOTH_ENABLE_REQUEST_CODE)
        } else {
            Toast.makeText(this, "Bluetooth is already enabled", Toast.LENGTH_SHORT).show()
        }
    }

    // Handle permission results
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == BLUETOOTH_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Bluetooth Permission Granted", Toast.LENGTH_SHORT).show()
                enableBluetooth()
            } else {
                Toast.makeText(this, "Bluetooth Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Handle Bluetooth enabling result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == BLUETOOTH_ENABLE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth Enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Bluetooth Not Enabled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}