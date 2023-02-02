package com.nohjunh.basic.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nohjunh.basic.database.entity.SentenceEntity

@Dao
interface SentenceDAO {

    @Query("SELECT * FROM SentenceTable")
    fun getAllData() : List<SentenceEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : SentenceEntity)

    @Query("DELETE FROM SentenceTable")
    fun delAllData()

}