package com.capgemini.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Demoactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demoactivity)
    }

    fun buttonclick(v: View) {
        val id=v.id
        lateinit var i: Intent
        when(id){
            R.id.radioB->{
                Toast.makeText(this,"Radio demo button",Toast.LENGTH_LONG).show()
                i=Intent(this,Radiobuttonactivity::class.java)
            }
            R.id.checkB->{
                Toast.makeText(this,"Checkbox demo button",Toast.LENGTH_LONG).show()
                i=Intent(this,Checkboxactivity::class.java)
            }
            R.id.listB->{
                Toast.makeText(this,"Listview demo button",Toast.LENGTH_LONG).show()
                i=Intent(this,Listviewactivity::class.java)
            }
            R.id.spinB->{Toast.makeText(this,"spinner demo button",Toast.LENGTH_LONG).show()
                i=Intent(this,Spinneractivity::class.java)}
            R.id.customB->{
                Toast.makeText(this,"Custom adapter demo button",Toast.LENGTH_LONG).show()
                i=Intent(this,Customadapteractivity::class.java)

            }
        }
        startActivity(i)
    }

    fun fabclick(view: View) {
        val i=Intent(this,Webviewactivity::class.java)
        startActivity(i)
    }

}