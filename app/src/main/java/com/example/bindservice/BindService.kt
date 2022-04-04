package com.example.bindservice

import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class BindService : Service() {

    val localBinder = LocalBinder()
    override fun onBind(intent: Intent): IBinder {
        return localBinder
    }

    inner class LocalBinder : Binder(){
        fun getBindServiceInstance() : BindService{
            return this@BindService
        }
    }

    fun test(){
        Log.d(TAG, "test : Hi From Service" )
    }

    companion object{
        private const val TAG = "BindService"
    }

}