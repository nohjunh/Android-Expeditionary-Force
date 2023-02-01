package com.nohjunh.basic.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nohjunh.basic.model.Post
import com.nohjunh.basic.network.Apis
import com.nohjunh.basic.network.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val retrofitInstance = RetrofitInstance.getInstance().create(Apis::class.java)

    private var _mutableApiDataList = MutableLiveData<Post>()
    val apiDataList : LiveData<Post>
        get() = _mutableApiDataList

    private var _mutableApiData2 = MutableLiveData<String>("Loading")
    val apiData2 : LiveData<String>
        get() = _mutableApiData2

    fun getPostAll() = viewModelScope.launch {
        val post = retrofitInstance.getPostAll()
        Log.d("ViewModel", post.toString())
        _mutableApiDataList.value = post
    }

    fun getPostNum(number : Int) = viewModelScope.launch {
        val post = retrofitInstance.getPostNum(number)
        Log.d("ViewModel", post.title.toString())
        Log.d("ViewModel", post.body.toString())
        _mutableApiData2.value = post.title.toString()
    }

}