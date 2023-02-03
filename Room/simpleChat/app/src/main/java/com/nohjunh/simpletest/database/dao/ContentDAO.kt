package com.nohjunh.simpletest.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nohjunh.simpletest.database.entity.ContentEntity

@Dao
interface ContentDAO {
    @Query("SELECT * FROM ContentTable")
    fun getAllContent() : List<ContentEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(content : ContentEntity)

    @Query("DELETE FROM ContentTable")
    fun delAllContent()

    @Query("DELETE FROM ContentTable WHERE id = :id")
    fun delSelectContent(id : Int)

}