package com.example.habr.awesomeapp

import android.os.Bundle
import habr.example.hello
import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity : FlutterActivity() {

    companion object {
        private const val CHANNEL = "habr.example.flutter/hello"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegistrant.registerWith(this)
        MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "getHello") {
                result.success(hello())
            } else {
                result.notImplemented()
            }
        }
    }
}
