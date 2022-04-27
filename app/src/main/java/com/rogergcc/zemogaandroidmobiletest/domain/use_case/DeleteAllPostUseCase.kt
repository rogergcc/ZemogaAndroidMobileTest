package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.repository.PostRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteAllPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke(): Flow<Resource<Boolean>> {
        return deleteAll()
    }

    private fun deleteAll(): Flow<Resource<Boolean>> {
        return postRepository.deleteAllPosts()
    }

}