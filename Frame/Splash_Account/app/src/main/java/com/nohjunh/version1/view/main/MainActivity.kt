package com.nohjunh.version1.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nohjunh.version1.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.tag("MainActivity").e("onCreate")

    }
}