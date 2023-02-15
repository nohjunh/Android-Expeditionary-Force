package com.nohjunh.test

import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 의존성을 위해 ViewModel에서는 Repository를 통해서만
// data source를 다루게 된다.
// 이 MainViewModel에서 참조하게 될 Repository class를
// 생성자로 받아온다.

class MainViewModel(
    private val repositoryImpl: MainRepositoryImpl
) : ViewModel() {

    val counterRepository : LiveData<Int>
        get() = repositoryImpl.getCounterLiveData()

//    private var _counter = MutableLiveData<Int>(100)
//    val counter : LiveData<Int>
//        get() = _counter

//    fun getCounter() = viewModelScope.launch(Dispatchers.Main) {
//        // DB, Network 작업이면 Dispatchers.IO와 postValue로 바꿔줘야 함.
//        // 예제에서는 단순히 값을 가져오는 것이기에 .value로 처리함.
//        counterRepository.value
//    }

    fun increaseCounter() = viewModelScope.launch(Dispatchers.Main) {
        repositoryImpl.increaseCounter()
    }

}