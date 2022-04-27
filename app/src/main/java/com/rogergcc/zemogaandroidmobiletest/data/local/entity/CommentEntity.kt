package com.rogergcc.zemogaandroidmobiletest.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment

@Entity
data class CommentEntity(
    val postId: Int,
    @PrimaryKey val id: Int,
    val name: String,
    val email: String,
    val body: String
) {
    fun toComment() : Comment {
        return Comment(
            postId, id, name, email, body
        )
    }
}
