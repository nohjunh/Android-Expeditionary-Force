package com.nohjunh.sample.repository

import com.nohjunh.sample.network.Apis
import com.nohjunh.sample.network.RetrofitInstance

class NetWorkRepository {

    private val bithumbClient = RetrofitInstance.getInstance().create(Apis::class.java)

    suspend fun getAllCoinData() = bithumbClient.getAllCoinData()

}