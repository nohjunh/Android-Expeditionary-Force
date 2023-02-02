package com.nohjunh.basic.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "textTable")
data class TextEntity (
     @PrimaryKey(autoGenerate = true)
     @ColumnInfo(name = "id")
     var id : Int,
     @ColumnInfo(name = "text")
     var text : String
)