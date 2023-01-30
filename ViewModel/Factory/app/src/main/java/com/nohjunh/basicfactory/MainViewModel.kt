package com.nohjunh.basicfactory

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

class MainViewModel(number : Int) : ViewModel() {

    init {
        Log.d("TEST", number.toString())
    }

}