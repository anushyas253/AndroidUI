package com.capgemini.androidui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class Mydialog:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        lateinit var dlg: Dialog

        val bundle=arguments//GETTING data from main
        val message=bundle?.getString("msg")
        val btn1_title=bundle?.getString("btn1")
        val btn2_title=bundle?.getString("btn2")
        val dlgtype=bundle?.getInt("type")
        //AlertDialog
        val parent=activity!!
        val builder=AlertDialog.Builder(parent)
        //val v=layoutInflater.inflate(R.layout.activity_main,null)
//        builder.setView(R.layout.activity_main)
        when(dlgtype){
            1->{
                builder.setTitle("Confirmation")
                builder.setMessage(message)
                builder.setPositiveButton(btn1_title,DialogInterface.OnClickListener {
                    _, _->
                    parent.finish()


                })

                builder.setNegativeButton(btn2_title)
                {dlg,i->
                    dlg.cancel()
                }
                builder.setNeutralButton("Cancel"){
                    dlg,i->
                    dlg.cancel()
                }
                dlg=builder.create()
                dlg.setCancelable(false)
            }
            2->{//timepicker dialog
                dlg=TimePickerDialog(parent,parent as TimePickerDialog.OnTimeSetListener,12,0,false)

            }
            3->{//datepicker
                val calendar= Calendar.getInstance()
                dlg=DatePickerDialog(parent,parent as DatePickerDialog.OnDateSetListener,
                calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))

            }
        }


        return dlg

    }

}