package com.nohjunh.basic.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nohjunh.basic.database.entity.WordEntity

@Dao
interface WordDAO {
    @Query("SELECT * FROM WordTable")
    fun getAllData() : List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word : WordEntity)

    @Query("DELETE FROM WordTable")
    fun delAllData()

}