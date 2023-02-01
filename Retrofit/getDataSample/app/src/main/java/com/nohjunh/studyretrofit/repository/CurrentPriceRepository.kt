package com.nohjunh.studyretrofit.repository

import com.nohjunh.studyretrofit.network.CurrentPriceService
import com.nohjunh.studyretrofit.network.RetrofitInstance
import retrofit2.create

class CurrentPriceRepository {

    private val currentPriceService = RetrofitInstance.getInstance().create(CurrentPriceService::class.java)

    fun getCurrentList(): CurrentPriceService = currentPriceService
}