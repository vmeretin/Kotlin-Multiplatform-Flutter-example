package com.example.habr.awesomeapp

import android.app.Application
import android.util.Log
import habr.example.hello
import io.flutter.facade.Flutter

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Flutter.startInitialization(this)
        Log.d("tag1", hello())
    }
}