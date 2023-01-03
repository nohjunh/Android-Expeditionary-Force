package com.nohjunh.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Room은 class명과 column명을 각각 DB table명, 멤버변수명으로 default로 가져가기에,
// tableName="ㅁㅁ"을 통해 사용자가 ㅁㅁ로 테이블명을 지정할 수 있음.
// name="ㅁㅁ"로 사용자가 ㅁㅁ로 컬럼명을 지정할 수 있음.

@Entity(tableName= "word_table")
data class Word (
    @PrimaryKey @ColumnInfo(name = "word") val word: String
)
