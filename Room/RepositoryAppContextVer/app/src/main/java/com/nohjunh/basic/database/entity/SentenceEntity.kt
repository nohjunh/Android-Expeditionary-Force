package com.nohjunh.basic.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SentenceTable")
data class SentenceEntity (
     @PrimaryKey(autoGenerate = true)
     @ColumnInfo(name = "id")
     var id : Int,
     @ColumnInfo(name = "sentence")
     var sentence : String
)