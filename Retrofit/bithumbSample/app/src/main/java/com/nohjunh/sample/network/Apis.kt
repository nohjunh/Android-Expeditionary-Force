package com.nohjunh.sample.network

import com.nohjunh.sample.model.CurrentStatus
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {

    @GET("public/ticker/ALL_KRW")
    suspend fun getAllPriceData(
    ) : CurrentStatus

}