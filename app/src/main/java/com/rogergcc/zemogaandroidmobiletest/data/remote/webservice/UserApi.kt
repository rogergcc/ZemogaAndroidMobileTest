package com.rogergcc.zemogaandroidmobiletest.data.remote.webservice

import com.rogergcc.zemogaandroidmobiletest.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id : Int) : UserDto

}