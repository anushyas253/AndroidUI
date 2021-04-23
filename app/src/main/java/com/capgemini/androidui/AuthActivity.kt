package com.capgemini.androidui

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color.red
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_auth.view.*


class AuthActivity : AppCompatActivity() {
    var isdataentered=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        //userid
        userE.setText("anushya@capgemini.com",TextView.BufferType.NORMAL)
        passE.setOnKeyListener { v, i, event ->
            if(event.action==KeyEvent.ACTION_DOWN && i==KeyEvent.KEYCODE_ENTER){
                if(passE.text.toString().length<8){
                    passE.backgroundTintList= ColorStateList.valueOf(resources.getColor(R.color.red))
                }
                else{
                    passE.backgroundTintList=ColorStateList.valueOf(resources.getColor(R.color.black))
                }
                true
            }
            false
        }

    }

    override fun onResume() {
        super.onResume()
        val nManager =getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        nManager.cancel(1)
    }

    fun submitClick(view: View) {
        Toast.makeText(this, "Succesfully logged IN", Toast.LENGTH_LONG).show()
        val ui=userE.text.toString()
        val pass=passE.text.toString()
        //do validation on data
        if(ui.isNotEmpty() && pass.isNotEmpty()){
            Toast.makeText(this,"you entered \nUserId: :$ui \nPassword: $pass",Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Please enter all data...",Toast.LENGTH_LONG).show()
        }

    }


    fun cancelclick(view: View) {
        Toast.makeText(this, "Exited", Toast.LENGTH_LONG).show()
        finish()//destroys activity and goes back to previous like cancel button
    }

    override fun onPause() {
        super.onPause()
        if(!isdataentered){
            //send notification
            sendNotification()

        }

    }
    //8.0(oreo) and above -notification must be assoiciated by a Channel

    private fun sendNotification() {
        //1.get the reference of notification manager
        val nManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        //notification nManager=(notificationn manager)getSystemService(notification_serivice)

        lateinit var builder:Notification.Builder
        //2.Create the notification CHANNEL
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {

            val channel = NotificationChannel("test", "AndriodUI",NotificationManager.IMPORTANCE_DEFAULT )
            //notification setting can be done here
            nManager.createNotificationChannel(channel)//registering channel

            builder=Notification.Builder(this,"test")
        }
        else {
            val builder = Notification.Builder(this)
        }
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setContentTitle("Authentication")
        builder.setContentText("Please complete sign-in procedure")
        builder.setAutoCancel(true)

        val tryIntent=Intent(this,MainActivity::class.java)
        val resumeIntent=PendingIntent.getActivity(this,0,tryIntent,0)
        val resumeaction= Notification.Action.Builder(android.R.drawable.ic_dialog_info,"Try again",resumeIntent).build()

        builder.addAction(resumeaction)

        //for making custom view notification
        val l=layoutInflater.inflate(R.layout.activity_main,null)
        //create remote view
        //set remote view
        //builder.setCustomContentView()

        var i= Intent(this,AuthActivity::class.java)
        val pi= PendingIntent.getActivity(this,0,i,0)

        builder.setContentIntent(pi)

        val mynotification=builder.build()
        mynotification.flags=Notification.FLAG_AUTO_CANCEL or Notification.FLAG_NO_CLEAR//prompting
        //mynotification.flags=Notification.FLAG_AUTO_CANCEL | Notification.FLAG_NO_CLEAR in java



        //3.Send the notification
        nManager.notify(1,mynotification)

    }

}