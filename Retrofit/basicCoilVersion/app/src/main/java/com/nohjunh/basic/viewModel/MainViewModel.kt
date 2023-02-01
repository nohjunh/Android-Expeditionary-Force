package com.nohjunh.basic.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nohjunh.basic.model.PlantList
import com.nohjunh.basic.network.Apis
import com.nohjunh.basic.network.RetrofitInstance
import com.nohjunh.basic.repository.NetWorkRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val netWorkRepository = NetWorkRepository()

    private var _mutableApiResult = MutableLiveData<PlantList>()
    val apiResult : LiveData<PlantList>
        get() = _mutableApiResult


    fun getAllData() = viewModelScope.launch {
        Log.d("ViewModel", "API통신 성공")
        _mutableApiResult.value = netWorkRepository.getAllData()
    }

}