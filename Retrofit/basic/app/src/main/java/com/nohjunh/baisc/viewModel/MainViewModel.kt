package com.nohjunh.baisc.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nohjunh.baisc.api.Apis
import com.nohjunh.baisc.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainViewModel : ViewModel() {

    private var _mutableApiData1 = MutableLiveData<String>()
    val apiData1 : LiveData<String>
        get() = _mutableApiData1


    private var _mutableApiData2 = MutableLiveData<String>()
    val apiData2 : LiveData<String>
        get() = _mutableApiData2

    private val retrofitInstance = RetrofitInstance.getInstance().create(Apis::class.java)

    fun getPost() = viewModelScope.launch {
        val post = retrofitInstance.getPost()
        Log.d("ViewModelNetwork", post.toString())
        _mutableApiData1.value = post[1].title
    }

    fun getPostNum(number : Int) = viewModelScope.launch {
        val postNum = retrofitInstance.getPostNum(number)
        Log.d("viewModelNetworkNumber", postNum.title.toString())
        Log.d("viewModelNetworkNumber", postNum.body.toString())
        _mutableApiData2.value = postNum.title
    }

}