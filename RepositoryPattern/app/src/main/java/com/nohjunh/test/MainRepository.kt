package com.nohjunh.test

import androidx.lifecycle.LiveData

// API 명세를 interface에 정의
interface MainRepository {
    fun getCounterLiveData() : LiveData<Int>
    fun increaseCounter()
}