package com.capgemini.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listviewactivity.*

class Listviewactivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    val langlist= mutableListOf("Kotin","Python","Java","Swift","C","C++","sql","html","Javascript","Dart")
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listviewactivity)

        //Adapter (used for data to be bound)-supplying the data to the viewer
        //2.defines layout of each item
        /*
        listview,spinner,recyclerview->AdapterViews
        1.ArrayAdapter
        2.CursorAdapter
         */
        adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,langlist)
        lv.adapter=adapter//data binding
        lv.setOnItemClickListener(this)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        val selectedlist=langlist[index]
        Toast.makeText(this,"Selected ITEM: $selectedlist",Toast.LENGTH_LONG).show()

        langlist.removeAt(index)//data updated
        adapter.notifyDataSetChanged()//make listview redrawn after data updation

    }


}
