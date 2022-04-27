package com.rogergcc.zemogaandroidmobiletest.domain.model

import com.rogergcc.zemogaandroidmobiletest.data.local.entity.PostEntity

data class Post(
    val userId : Int,
    val id : Int,
    val title : String,
    val body : String,
    val isFavourite : Int
){
    fun toPostEntity() : PostEntity{
        return PostEntity(
            userId = userId,
            id = id,
            title = title,
            body = body,
            isFavourite = isFavourite
        )
    }
}
