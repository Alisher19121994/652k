package com.example.a652k

import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var intentCall: IntentCall

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initVIiews()

    }

    private fun initVIiews() {
        intentCall = IntentCall()

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE), 1)
        }

    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(Intent.ACTION_CALL)
        registerReceiver(intentCall, filter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(intentCall)

    }
}