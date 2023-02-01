package com.nohjunh.basic.repository

import com.nohjunh.basic.network.Apis
import com.nohjunh.basic.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Apis::class.java)

    suspend fun getAllData() = client.getAllData()
    
}