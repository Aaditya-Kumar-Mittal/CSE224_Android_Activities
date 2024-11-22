package com.example.kotlin_project

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CAThree : AppCompatActivity() {

    val STORAGE_PERMISSION_CODE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cathree)

        val storageButton = findViewById<Button>(R.id.uploadBtn)

        storageButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                requestStoragePermission()
            } else {
                Toast.makeText(this, "Storage permissions already granted", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun requestStoragePermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            STORAGE_PERMISSION_CODE
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Storage permissions granted", Toast.LENGTH_SHORT).show()
            } else {
                // Show a dialog when permission is denied
                showPermissionDeniedDialog()
            }
        }
    }


    private fun showPermissionDeniedDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Permission Required")
            .setMessage("Storage permission is required to proceed.")
            .setPositiveButton("Try Again") { dialog, _ ->
                dialog.dismiss()
                requestStoragePermission()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
            .create()

        alertDialog.show()
    }
}