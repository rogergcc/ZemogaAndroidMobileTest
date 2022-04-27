package com.rogergcc.zemogaandroidmobiletest.data.remote.dto

import com.rogergcc.zemogaandroidmobiletest.data.local.entity.CommentEntity
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment

data class CommentDto(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
) {
    fun toCommentEntity() : CommentEntity {
        return CommentEntity(
            postId, id, name, email, body
        )
    }

    fun toComment() : Comment {
        return Comment(
            postId, id, name, email, body
        )
    }
}
