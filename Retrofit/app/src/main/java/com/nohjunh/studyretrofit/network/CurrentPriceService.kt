package com.nohjunh.studyretrofit.network

import com.nohjunh.studyretrofit.network.model.CurrentPriceDTO
import retrofit2.Call
import retrofit2.http.GET

interface CurrentPriceService {

    @GET("public/ticker/ALL_KRW")
    fun getCurrentValues() : Call<CurrentPriceDTO>
}
