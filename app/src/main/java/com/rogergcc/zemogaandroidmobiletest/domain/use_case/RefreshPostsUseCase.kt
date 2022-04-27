package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post
import com.rogergcc.zemogaandroidmobiletest.domain.repository.PostRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefreshPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke(): Flow<Resource<List<Post>>> {
        return readPosts()
    }

    private fun readPosts(): Flow<Resource<List<Post>>> {
        return postRepository.fetchAllPosts()
    }

}