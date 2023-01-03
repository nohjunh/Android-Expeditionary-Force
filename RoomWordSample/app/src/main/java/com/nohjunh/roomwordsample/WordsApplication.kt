package com.nohjunh.roomwordsample

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/*
앱에 Database Instance와 Repository Instance를 하나씩만 사용하기 위해
Instance를 Application 클래스의 멤버로 생성 구성
-> 매번 구성하지 않고 필요할 때마다 Application에서 가져올 수 있음.
 */
class WordsApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts

    // 앱을 시작할 때가 아닌 처음 필요할 때만 만들기 위해 by lazy 사용
    // DB instance 생성
    private val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    // Database DAO에 기반한 Repository instance 생성
    val repository by lazy { WordRepository(database.wordDao()) }

}