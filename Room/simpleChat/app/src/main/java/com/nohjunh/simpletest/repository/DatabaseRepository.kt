package com.nohjunh.simpletest.repository

import com.nohjunh.simpletest.App
import com.nohjunh.simpletest.database.ChatDatabase
import com.nohjunh.simpletest.database.entity.ContentEntity

class DatabaseRepository {

    val context = App.context()
    val database = ChatDatabase.getDatabase(context)

    fun getAllContent() = database.contentDAO().getAllContent()
    fun insertContent(content : String) = database.contentDAO().insert(ContentEntity(0, content))
    fun delAllContent() = database.contentDAO().delAllContent()
    fun delSelectContent(id : Int) = database.contentDAO().delSelectContent(id)

}