package com.nohjunh.roomwordsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities= arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao

    // WordRoomDatabase를 Singleton으로 정의해 동시에 여러 인스턴스가 열리는 것을 막음
    companion object {
        // @Volatile 어노테이션으로 변수 선언 시 해당 변수를 메인 메모리에만 적재시킴.
        // https://www.charlezz.com/?p=45959
        // Volatile 어노테이션을 사용하지 않는 일반적인 경우, 성능 향상을 위해 내부적으로 메인 메모리로부터 읽어온 값을 CPU 캐시에 저장한다.
        // 하지만 멀티쓰레드 애플리케이션에서는 각 쓰레드를 통해 CPU에 캐싱한 값이 상이할 수 있다
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        /*
         getDatabase는 싱글톤 반환 ->
         DB를 만들어 Room의 databaseBuilder를 사용해 WordRoomDatabase 클래스의
         애플리케이션 컨텍스트에서 RoomDatabase 객체를 만들고
         해당 DB이름을 "word_database"로 지정
         */

        fun getDatabase(context: Context,
                        scope: CoroutineScope // 코루틴 scope
        ) : WordRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope)) // .build()를 호출하기 전에 buildSequence에 콜백 추가
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        // 앱을 만들 때마다 모든 정보를 삭제하고 정보를 다시 DB에 채우려면 RoomDatabase.Callback을 만들고 onCreate()를 재정의
        // Room DB 작업을 UI 스레드에서는 수행 불가 ->
        // onCreate() 작업은 IO Dispatcher에서 코루틴 실행함.
        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.wordDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(wordDao: WordDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            wordDao.deleteAll()

            var word = Word("Hello")
            wordDao.insert(word)
            word = Word("World!")
            wordDao.insert(word)
        }
    }
}