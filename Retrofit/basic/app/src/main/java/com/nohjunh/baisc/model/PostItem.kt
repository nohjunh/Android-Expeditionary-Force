package com.nohjunh.baisc.model

import com.google.gson.annotations.SerializedName

data class PostItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)