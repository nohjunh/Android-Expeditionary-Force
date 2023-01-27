package com.nohjunh.version1.view.preview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nohjunh.version1.R
import timber.log.Timber

// Splash 포함
class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        Timber.tag("PreviewActivity").e("onCreate")

    }
}