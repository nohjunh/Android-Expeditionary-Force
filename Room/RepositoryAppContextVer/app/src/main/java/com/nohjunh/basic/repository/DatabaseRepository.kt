package com.nohjunh.basic.repository

import com.nohjunh.basic.App
import com.nohjunh.basic.database.TextDataBase
import com.nohjunh.basic.database.entity.SentenceEntity
import com.nohjunh.basic.database.entity.WordEntity

class DatabaseRepository {

    val context = App.context()
    val database = TextDataBase.getDatabase(context)

    fun getWordData() = database.wordDAO().getAllData()
    fun getSentenceData() = database.sentenceDAO().getAllData()

    fun insertWordData(text : String) = database.wordDAO().insert(WordEntity(0, text))
    fun insertSentenceData(text : String) = database.sentenceDAO().insert(SentenceEntity(0, text))

    fun delWordData() = database.wordDAO().delAllData()
    fun delSentenceData() = database.sentenceDAO().delAllData()

}