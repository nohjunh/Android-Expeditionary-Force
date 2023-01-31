package com.nohjunh.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _changedNumber = MutableLiveData<Int>(0)
    val changedNumber : LiveData<Int>
        get() = _changedNumber

    fun plusLiveDataNumber() {
        _changedNumber.value = _changedNumber.value!!.plus(1)
    }
    fun minusLiveDataNumber() {
        _changedNumber.value = _changedNumber.value!!.minus(1)
    }
}