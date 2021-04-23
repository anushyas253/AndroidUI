package com.capgemini.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webviewactivity.*
//phonegap,cordova,React Native-hybrid mobile app framwork
/*
code once development and deploy on multi platforms
 */

class Webviewactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webviewactivity)
        webcontent.settings.javaScriptEnabled=true
        webcontent.loadUrl("https://www.capgemini.com")

    }
}