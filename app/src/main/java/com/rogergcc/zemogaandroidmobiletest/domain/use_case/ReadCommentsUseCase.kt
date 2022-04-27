package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment
import com.rogergcc.zemogaandroidmobiletest.domain.repository.CommentRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {

    operator fun invoke(postId: Int): Flow<Resource<List<Comment>>> {
        return readComments(postId)
    }

    private fun readComments(postId: Int): Flow<Resource<List<Comment>>> {
        return commentRepository.getCommentsOfPost(postId)
    }

}