package com.nohjunh.basic.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nohjunh.basic.database.entity.SentenceEntity
import com.nohjunh.basic.database.entity.WordEntity
import com.nohjunh.basic.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {

    private var _sentenceList = MutableLiveData<List<SentenceEntity>>()
    val sentenceList : LiveData<List<SentenceEntity>>
        get() = _sentenceList

    private val databaseRepository = DatabaseRepository()

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    fun getAllData() = viewModelScope.launch(Dispatchers.IO) {
        _sentenceList.postValue(databaseRepository.getSentenceData())
        _wordList.postValue(databaseRepository.getWordData())
    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.insertSentenceData(text)
        databaseRepository.insertWordData(text)
    }

    fun deleteData() = viewModelScope.launch(Dispatchers.IO) {
        databaseRepository.delSentenceData()
        databaseRepository.delWordData()
    }
}