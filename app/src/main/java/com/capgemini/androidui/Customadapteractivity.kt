package com.capgemini.androidui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_customadapteractivity.*
import kotlinx.android.synthetic.main.activity_listviewactivity.*

class Customadapteractivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    var listofstudents= mutableListOf<Student>()
    //var adapter:ArrayAdapter<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customadapteractivity)
        listofstudents.add(Student("John",1,88.2))
        listofstudents.add(Student("sam",2,90.2))
        listofstudents.add(Student("mike",3,67.2))
        listofstudents.add(Student("porter",4,78.2))
        listofstudents.add(Student("evie",5,80.2))
        listofstudents.add(Student("John",1,88.2))
        listofstudents.add(Student("sam",2,90.2))
        listofstudents.add(Student("mike",3,67.2))
        listofstudents.add(Student("porter",4,78.2))
        listofstudents.add(Student("evie",5,80.2))
        listofstudents.add(Student("John",1,88.2))
        listofstudents.add(Student("sam",2,90.2))
        listofstudents.add(Student("mike",3,67.2))
        listofstudents.add(Student("porter",4,78.2))
        listofstudents.add(Student("evie",5,80.2))
        val adapter =MyAdapter(this,R.layout.student_list_item,listofstudents)

        studentL.adapter=adapter
        studentL.setOnItemClickListener(this)

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        val std=listofstudents[index]
       // std=adapter.getItem(index)!!
        //adapter.notifyDatasetchamged()
        Toast.makeText(this,"Selected ITEM: name:${std?.name}id: ${std.id}", Toast.LENGTH_LONG).show()

    }

}
data class Student(val name:String,val id:Int,val percentage:Double)
class MyAdapter(context:Context,val layoutRes:Int,val data:List<Student>):ArrayAdapter<Student>(context,layoutRes,data){
    override fun getItem(position: Int): Student? {
        return data[position]
    }

    //executed multiple times as no of times of elements of array
    //create view and bind data to it
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val student=getItem(position)
        //view creation-conditional

        val view=convertView ?:LayoutInflater.from(context).inflate(layoutRes, null)
//        if(convertView!=null) {
//            val view = LayoutInflater.from(context).inflate(layoutRes, null)
//
//        }
//        else
//            view=convertView!!

        //bind data appropriately

        val nameT=view.findViewById<TextView>(R.id.nameT)
        val rollT=view.findViewById<TextView>(R.id.rollT)
        val percT=view.findViewById<TextView>(R.id.percT)
        nameT.text=student?.name
        rollT.text="${student?.id}"
        percT.text="${student?.percentage}"

        return view
    }



}
