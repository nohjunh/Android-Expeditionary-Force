package com.nohjunh.basic.network

import com.nohjunh.basic.model.Post
import com.nohjunh.basic.model.PostItem
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {

    @GET("posts/")
    suspend fun getPostAll() : Post

    @GET("posts/{number}")
    suspend fun getPostNum(
        @Path("number") number : Int
    ) : PostItem
}