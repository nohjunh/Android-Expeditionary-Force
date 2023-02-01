package com.nohjunh.basic.model


import com.google.gson.annotations.SerializedName

data class PlantListItem(
    val description: String,
    val growZoneNumber: Int,
    val imageUrl: String,
    val name: String,
    val plantId: String,
    val wateringInterval: Int
)