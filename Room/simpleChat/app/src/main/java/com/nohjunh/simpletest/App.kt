package com.nohjunh.simpletest

import android.app.Application
import android.content.Context
import timber.log.Timber

class App : Application() {

    // context -> global
    init {
        instance = this
    }
    companion object {
        private var instance: App? = null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }

    // Timber setting
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}