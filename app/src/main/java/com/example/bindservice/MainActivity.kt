package com.example.bindservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val intent = Intent(MainActivity@ this, BindService::class.java)

            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

    }

    val serviceConnection: ServiceConnection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, iBinder: IBinder?) {

            Log.d(TAG, "onServiceConnected: ")

            val localBinder : BindService.LocalBinder = iBinder as BindService.LocalBinder

            val service : BindService = localBinder.getBindServiceInstance()

            service.test()

        }

        override fun onServiceDisconnected(name: ComponentName) {
            Log.d(TAG, "onServiceDisconnected: ")
        }

    }

    companion object{
        private const val TAG = "MainActivity"
    }

}