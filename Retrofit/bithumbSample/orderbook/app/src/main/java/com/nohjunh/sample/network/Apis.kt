package com.nohjunh.sample.network

import com.nohjunh.sample.model.CurOrderBook
import retrofit2.http.GET

interface Apis {

    @GET("public/orderbook/ALL_KRW")
    suspend fun getAllCoinData() : CurOrderBook

}