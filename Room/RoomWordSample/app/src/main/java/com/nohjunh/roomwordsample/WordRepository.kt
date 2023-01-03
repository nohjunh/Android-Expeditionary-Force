package com.nohjunh.roomwordsample

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/*
DAO는 전체 Database가 아닌 repository 생성자에 전달됨.
DAO에 Database의 모든 쿼리 메소드가 포함되어 있으므로 DAO 액세스만 필요하기 때문.
전체 Database를 repository에 노출할 필요가 없음.
*/
class WordRepository(private val wordDao: WordDao) {

    // Room은 별도의 스레드에서 모든 쿼리를 실행
    // Observed Flow will notify the observer when the data has changed.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    // Room은 기본적으로 메인 스레드 밖에서 suspend 쿼리 실행.
    // therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}