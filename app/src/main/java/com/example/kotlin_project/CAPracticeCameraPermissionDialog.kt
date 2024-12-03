package com.example.kotlin_project

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class CAPracticeCameraPermissionDialog : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capractice_camera_permission_dialog)

        // Check and request camera permission on startup
        if (isCameraPermissionGranted()) {
            openCamera()
        } else {
            requestCameraPermission()
        }
    }

    /**
     * Checks if the camera permission is granted.
     */
    private fun isCameraPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Requests camera permission.
     */
    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_PERMISSION_REQUEST_CODE
        )
    }

    /**
     * Opens the camera if the permission is granted.
     */
    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Verify if the device has a camera app to handle the intent
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivity(takePictureIntent)
        } else {
            Toast.makeText(this, "No camera app available", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Handles the result of the permission request.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, open camera
                openCamera()
            } else {
                // Permission denied, show dialog
                showPermissionDeniedDialog()
            }
        }
    }

    /**
     * Shows a dialog box when the camera permission is denied.
     */
    private fun showPermissionDeniedDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Permission Required")
            .setMessage("Camera permission is required to use this feature.")
            .setPositiveButton("OK") { dialog, _ ->
                // Ask for permission again
                dialog.dismiss()
                requestCameraPermission()
            }
            .setNegativeButton("Dismiss") {dialog, _->
                // Close the dialog and show a toast
                dialog.dismiss()
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
            .create()
        alertDialog.show()
    }
}