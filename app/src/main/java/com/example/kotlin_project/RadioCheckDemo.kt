package com.example.kotlin_project

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioCheckDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio_check_demo)

        var rG = findViewById<RadioGroup>(R.id.pizzaSize)
        var orderBtn = findViewById<Button>(R.id.pizzaOrder)
        var check1 = findViewById<CheckBox>(R.id.checkBox1)
        var check2 = findViewById<CheckBox>(R.id.checkBox2)
        var check3 = findViewById<CheckBox>(R.id.checkBox3)

        var r1 = findViewById<RadioButton>(R.id.radioButton1)
        var r2 = findViewById<RadioButton>(R.id.radioButton2)
        var r3 = findViewById<RadioButton>(R.id.radioButton3)

        orderBtn.setOnClickListener{

            //Get the radio Button which is clicked using checkedRadioButtonId
            var size= rG.checkedRadioButtonId

            //Using when expression
            var pizzaSize = when(size){
                R.id.radioButton1 -> "Large"
                R.id.radioButton2 -> "Medium"
                R.id.radioButton3 -> "Small"
                else -> "Medium"
            }


        }
    }
}