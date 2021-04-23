package com.capgemini.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spinneractivity.*

class Spinneractivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val langlist= mutableListOf("Kotin","Python","Java","Swift","C","C++","sql","html","Javascript","Dart")
    //lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinneractivity)
        spinner.adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,langlist)
        //spinner.adapter=adapter
        spinner.onItemSelectedListener=this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        Toast.makeText(this,"Selected language: ${langlist[index]}",Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this,"Please select",Toast.LENGTH_LONG).show()
    }
}