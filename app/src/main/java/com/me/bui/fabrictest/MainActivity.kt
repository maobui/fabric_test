package com.me.bui.fabrictest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        btnCrash.setOnClickListener { view -> forceCrash(view) }
        btnException.setOnClickListener { _ -> forceException() }
    }

    fun forceCrash(view: View) {
        throw RuntimeException("This is a crash")
    }

    fun forceException() {
        try {
            val x = 1/0
        } catch (e: Exception) {
            Crashlytics.logException(e)
            e.printStackTrace()
        }
    }

}
