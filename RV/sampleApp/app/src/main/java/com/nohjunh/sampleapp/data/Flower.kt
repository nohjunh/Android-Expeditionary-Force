package com.nohjunh.sampleapp.data

import androidx.annotation.DrawableRes

data class Flower(
    val id: Long,
    val name: String,
    @DrawableRes
    val image: Int?,
    val description: String
)
