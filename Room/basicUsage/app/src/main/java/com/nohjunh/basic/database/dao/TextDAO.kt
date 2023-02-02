package com.nohjunh.basic.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nohjunh.basic.database.entity.TextEntity

@Dao
interface TextDAO {

    @Query("SELECT * FROM textTable")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : TextEntity)

    @Query("DELETE FROM textTable")
    fun delAllData()

}