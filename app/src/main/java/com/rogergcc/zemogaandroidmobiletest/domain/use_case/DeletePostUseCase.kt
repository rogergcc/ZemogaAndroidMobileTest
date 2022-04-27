package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post
import com.rogergcc.zemogaandroidmobiletest.domain.repository.PostRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke(post: Post): Flow<Resource<Post>> {
        return deletePost(post)
    }

    private fun deletePost(post: Post): Flow<Resource<Post>> {
        return postRepository.deletePost(post)
    }

}