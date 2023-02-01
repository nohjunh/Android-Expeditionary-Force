package com.nohjunh.basic.network

import com.nohjunh.basic.model.PlantList
import retrofit2.http.GET

interface Apis {

    @GET("10y01noo/googlecodelabs-kotlin-coroutines/main/advanced-coroutines-codelab/sunflower/src/main/assets/plants.json")
    suspend fun getAllData() : PlantList


}