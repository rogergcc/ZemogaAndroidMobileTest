package com.rogergcc.zemogaandroidmobiletest.data.remote.dto

import com.rogergcc.zemogaandroidmobiletest.data.local.entity.PostEntity
import com.rogergcc.zemogaandroidmobiletest.domain.model.Post

data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
){
    fun toPost() : Post{
        return Post(
            userId = userId,
            id = id,
            title = title,
            body = body,
            isFavourite = 0
        )
    }

    fun toPostEntity() : PostEntity {
        return PostEntity(
            userId = userId,
            id = id,
            title = title,
            body = body,
            isFavourite = 0
        )
    }
}