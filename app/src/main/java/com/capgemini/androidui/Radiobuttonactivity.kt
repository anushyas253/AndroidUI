package com.capgemini.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class Radiobuttonactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radiobuttonactivity)
    }


    fun radioclicked(view: View) {
        var selectedcity = ""
        if (view is RadioButton) {
            val isChecked = view.isChecked
            if (isChecked) {
                val id = view.id

                when (id) {
                    R.id.blrR -> {
                            selectedcity = view.text.toString()
                    }
                    R.id.bomR -> {
                            selectedcity = view.text.toString()
                    }
                    R.id.hydR -> {
                            selectedcity = view.text.toString()
                    }
                    R.id.dlhR -> {
                            selectedcity = view.text.toString()
                    }

                }

            }
            Toast.makeText(this, "Selected city: $selectedcity", Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()

    }

}



