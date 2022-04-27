package com.rogergcc.zemogaandroidmobiletest.data.remote.webservice

import com.rogergcc.zemogaandroidmobiletest.data.remote.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {

    @GET("posts")
    suspend fun getAllPosts() : List<PostDto>

    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") postId : Int) : PostDto

}