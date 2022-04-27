package com.rogergcc.zemogaandroidmobiletest.domain.repository

import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow

interface CommentRepository {

    fun getCommentsOfPost(postId: Int) : Flow<Resource<List<Comment>>>

}