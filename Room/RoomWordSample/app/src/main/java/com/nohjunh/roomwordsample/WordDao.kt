package com.nohjunh.roomwordsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao { // interface

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>> // word_table에 있는 모든 단어들을 가져와 Words의 List 반환

    // @Insert = SQL을 제공하지 않아도 자동으로 동작 가능한 특수 DAO 메소드
    @Insert(onConflict = OnConflictStrategy.IGNORE) // 이미 table에 있는 단어와 같다면 삽입하지 않고 무시
    suspend fun insert(word: Word) // 한 단어를 삽입 suspend func

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
