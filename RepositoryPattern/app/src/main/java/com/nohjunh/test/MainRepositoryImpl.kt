package com.nohjunh.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// MainRepository interface를 구현하는 구현체 클래스
class MainRepositoryImpl(counter : Int) : MainRepository {

    // Repository가 관리할 DB or Network Data가 있어야 함.
    // DB에서 가져온 데이터가 liveCounter라고 가정함.
    private val liveCounter = MutableLiveData<Int>(counter)

    override fun getCounterLiveData(): LiveData<Int> {
        return liveCounter
    }

    override fun increaseCounter() {
        liveCounter.value = liveCounter.value?.plus(1)
    }


}