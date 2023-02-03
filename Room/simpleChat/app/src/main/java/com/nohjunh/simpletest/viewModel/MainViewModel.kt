package com.nohjunh.simpletest.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nohjunh.simpletest.database.entity.ContentEntity
import com.nohjunh.simpletest.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val databaseRepository = DatabaseRepository()

    private var _contentList = MutableLiveData<List<ContentEntity>>()
    val contentList : LiveData<List<ContentEntity>>
        get() = _contentList

    private var _deleteCheck = MutableLiveData<Boolean>()
    val deleteCheck : LiveData<Boolean>
        get() = _deleteCheck


    fun getAllContent() = viewModelScope.launch(Dispatchers.IO) {
        _contentList.postValue(databaseRepository.getAllContent())
        _deleteCheck.postValue(false)
    }

    fun insertContent(content : String) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.insertContent(content)
    }

    fun delAllContent() = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.delAllContent()
    }

    fun delSelectContent(id : Int) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.delSelectContent(id)
        _deleteCheck.postValue(true)
    }

}