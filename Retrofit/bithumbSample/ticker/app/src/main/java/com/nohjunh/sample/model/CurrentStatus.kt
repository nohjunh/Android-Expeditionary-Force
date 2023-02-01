package com.nohjunh.sample.model

import com.google.gson.annotations.SerializedName

data class CurrentStatus(
    @SerializedName("status")
    val status: String?,

    @SerializedName("data")
    val data: Map<String, Any>
)
