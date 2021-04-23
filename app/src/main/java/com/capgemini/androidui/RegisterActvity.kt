package com.capgemini.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register_actvity.*;

class RegisterActvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_actvity)
    }

    fun registerclick(view: View) {

        val nameE =nameE.text.toString()
        val mobE=mobE.text.toString()
        val emE =emE.text.toString()
        val addE=addE.text.toString()

        if(nameE.isNotEmpty() && mobE.isNotEmpty() && emE.isNotEmpty() && addE.isNotEmpty()){
            Toast.makeText(this, "Succesfully Registered", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Please enter all data...", Toast.LENGTH_LONG).show()
        }
    }

    fun canclick(view: View) {
        Toast.makeText(this, "Exited Registration", Toast.LENGTH_LONG).show()
        finish()
    }

}