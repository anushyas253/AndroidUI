package com.capgemini.androidui

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main_constraint.*

class MainActivity : AppCompatActivity() ,View.OnClickListener,TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        var firstTimeUser=true
//        var registerbutton:Button
//        var msg:TextView


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_constraint)//Static UI creation
//        val parent=LinearLayout(this)
//        val tv=TextView(this)
//        parent.addView(tv)
//        setContentView(parent)//dynamic UI creation

        //regiter for context menu
        registerForContextMenu(demoB)

        signB.setOnClickListener(this)//registered listener tot the view
        registerB.setOnClickListener(this)//{
//            Toast.makeText(it.context,"Through Lambda:${it.id}",Toast.LENGTH_LONG).show()
//        }//one time use only lambda is nice

        //if first time user both buttons else only sign
        //hide the register button
//        registerbutton=findViewById(R.id.registerB)
//        msg=findViewById(R.id.id2)

        if(!firstTimeUser){
            //hide the register button
                //INvisble-view still part of heirarchy
                    //GONE- view gets removed from view hierarchy
            registerB.visibility=View.GONE
            id2.setText("Please Sign-In")
        }


    }
    override fun onClick(v: View?) {//view of which view is clicked
        val id=v!!.id
        //reaction to the click event
        when(id){
            R.id.registerB->{
//                Toast.makeText(this,"REGISTER Button Clicked",Toast.LENGTH_LONG).show()
//                val j=Intent(this,RegisterActvity::class.java)
//                startActivity(j)
                val pmenu=PopupMenu(this,registerB)
                val menu=pmenu.menu
                menu.add(0,1,0,"Driver")
                menu.add(0,2,0,"Rider")
                pmenu.show()
                pmenu.setOnMenuItemClickListener {
                    when(it.itemId) {
                        1 -> {
                            Toast.makeText(this, "Driver Selected", Toast.LENGTH_LONG).show()
                            val j = Intent(this, RegisterActvity::class.java)
                            startActivity(j)
                            true
                        }
                        else -> {
                            Toast.makeText(this, "Rider Selected", Toast.LENGTH_LONG).show()
                            val j = Intent(this, RegisterActvity::class.java)
                            startActivity(j)
                            true
                        }

                    }
                }
            }

            R.id.signB->{
                //Toast.makeText(this,"SIGN-IN Button Clicked",Toast.LENGTH_LONG).show()

                //snack bar
                val snack=Snackbar.make(parentL,"Signing-In...",Snackbar.LENGTH_LONG)
                snack.setAction("Undo",View.OnClickListener {
                    Snackbar.make(parentL,"Action undone....",Snackbar.LENGTH_LONG).show()
                })
                snack.show()
                //launch auth-activity
                val i=Intent(this,AuthActivity::class.java)//as intent is a java class//backstack also maintained
                startActivity(i)//activity manager
            }
        }
    }

    fun democlick(view: View) {
        val i=Intent(this,Demoactivity::class.java)
        startActivity(i)
    }
    val MENU_LOGIN=1
    val MENU_REGISTER=2
    val MENU_EXIT=3
    val MENU_TIME=4
    val MENU_DATE=5
    val MENU_PROGRESS=6
    val MENU_STOP=7
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val loginItem=menu?.add(0,MENU_LOGIN,0,"Login")
        loginItem?.setIcon(android.R.drawable.ic_dialog_info)
        loginItem?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu?.add(0,MENU_REGISTER,1,"REGISTER")
        menu?.add(0,MENU_EXIT,2,"EXIT")
        menu?.add(0,MENU_DATE,3,"pick date")
        menu?.add(0,MENU_TIME,4,"pick time")
        menu?.add(0,MENU_PROGRESS,5,"Start task")
        menu?.add(0,MENU_STOP,6,"Stop task")
        return super.onCreateOptionsMenu(menu)
    }
    lateinit var pdlg:ProgressDialog
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            MENU_LOGIN->{
                val i=Intent(this,AuthActivity::class.java)//as intent is a java class//backstack also maintained
                startActivity(i)
                return true
            }
            MENU_REGISTER->{
                val d=Mydialog()
                //put data for showing in the dialog class
                val bundle=Bundle()
                bundle.putString("msg","Please select user")
                bundle.putString("btn1","Rider")
                bundle.putString("btn2","Driver")
                bundle.putInt("type",1)

                d.arguments=bundle
                d.show(supportFragmentManager,"xyz")
//                val j=Intent(this,RegisterActvity::class.java)
//                startActivity(j)
                return true
            }
            MENU_EXIT->{
                //finish()
                //display dialog
                val d=Mydialog()
                //put data for showing in the dialog class
                val bundle=Bundle()
                bundle.putString("msg","Do you want to exit?")
                bundle.putString("btn1","yes")
                bundle.putString("btn2","no")
                bundle.putInt("type",1)

                d.arguments=bundle
                d.show(supportFragmentManager,"xyz")
                return true
            }
            MENU_TIME->{
                val d=Mydialog()
                //put data for showing in the dialog class
                val bundle=Bundle()
                bundle.putInt("type",2)
                d.arguments=bundle
                d.show(supportFragmentManager,"abc")

            }
            MENU_DATE->{
                val d=Mydialog()
                //put data for showing in the dialog class
                val bundle=Bundle()
                bundle.putInt("type",3)
                d.arguments=bundle
                d.show(supportFragmentManager,"mno")

            }
            MENU_PROGRESS->{
                //pdlg= ProgressDialog.show(this,"Downloading..","Please wait",true,true)

                progressBar.visibility=View.VISIBLE
                progressBar.progress=50
            }
            MENU_STOP->{
               // pdlg.cancel()
                progressBar.visibility=View.INVISIBLE
            }
        }
        return super.onOptionsItemSelected(item)
    }
    val MENU_RB=1
    val MENU_CB=2
    val MENU_LV=3
    val MENU_SP=4

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.demoB) {
            menu?.add(0, MENU_RB, 0, "Radio button")
            menu?.add(0, MENU_CB, 0, "Checkbox button")
            menu?.add(0, MENU_LV, 0, "List view button")
            menu?.add(0, MENU_SP, 0, "Spinner button")

        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        lateinit var intent:Intent
        when(item.itemId){
            MENU_RB->{intent=Intent(this,Radiobuttonactivity::class.java)}
            MENU_CB->{intent=Intent(this,Checkboxactivity::class.java)}
            MENU_LV->{intent=Intent(this,Listviewactivity::class.java)}
            MENU_SP->{intent=Intent(this,Spinneractivity::class.java)}
        }
        startActivity(intent)
        return true
    }

    override fun onTimeSet(view: TimePicker?, p1: Int, p2: Int) {
        Toast.makeText(this,"Time: $p1 hrs $p2 minutes",Toast.LENGTH_LONG).show()
    }

    override fun onDateSet(view: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(this,"Date:$p3-$p2-$p1",Toast.LENGTH_LONG).show()
    }


}