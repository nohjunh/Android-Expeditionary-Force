package com.nohjunh.basic.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {

    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    fun plusCountfunc() {
        _mutableCount.value = _mutableCount.value!!.plus(1)
    }

    fun minusCountfunc() {
        _mutableCount.value = _mutableCount.value!!.minus(1)
    }
}