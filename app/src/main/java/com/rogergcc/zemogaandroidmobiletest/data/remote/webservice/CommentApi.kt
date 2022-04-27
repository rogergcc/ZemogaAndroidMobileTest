package com.rogergcc.zemogaandroidmobiletest.data.remote.webservice

import com.rogergcc.zemogaandroidmobiletest.data.remote.dto.CommentDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CommentApi {

    @GET("posts/{id}/comments")
    suspend fun getCommentByPostId(@Path("id") postId : Int) : List<CommentDto>
}