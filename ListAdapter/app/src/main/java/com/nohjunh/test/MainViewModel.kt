package com.nohjunh.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private val dataSet = arrayListOf<DataEx>().apply {
    add(DataEx("피자", 10000, 3))
    add(DataEx("고기", 20000, 0))
    add(DataEx("치킨", 30000, 1))
}

class MainViewModel : ViewModel() {

    private var _liveDataSet = MutableLiveData<List<DataEx>>()
    val liveDataSet : LiveData<List<DataEx>>
        get() = _liveDataSet

    fun start() {
        _liveDataSet.value = dataSet
    }

    fun addData(data : List<DataEx>) {
        _liveDataSet.value = data
    }

}