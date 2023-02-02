package com.nohjunh.basic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nohjunh.basic.database.dao.SentenceDAO
import com.nohjunh.basic.database.entity.SentenceEntity

@Database(entities = [SentenceEntity::class], version = 1)
abstract class TextDataBase : RoomDatabase() {

    abstract fun sentenceDAO() : SentenceDAO

    companion object {
        @Volatile
        private var INSTANCE : TextDataBase? = null

        fun getDatabase(
            context : Context
        ) : TextDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDataBase::class.java,
                    "textDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}