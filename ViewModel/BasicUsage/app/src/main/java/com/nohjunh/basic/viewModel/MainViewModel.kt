package com.nohjunh.basic.viewModel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var countNumber= 0

    fun plus() {
        countNumber++
    }

    fun minus() {
        countNumber--
    }

    fun getNumber() : Int {
        return countNumber
    }
}