package com.nohjunh.baisc.api

import com.nohjunh.baisc.model.Post
import com.nohjunh.baisc.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {

    @GET("posts/")
    suspend fun getPost() : Post

    @GET("posts/{number}")
    suspend fun getPostNum(
        @Path("number") number : Int
    ) : PostItem

}