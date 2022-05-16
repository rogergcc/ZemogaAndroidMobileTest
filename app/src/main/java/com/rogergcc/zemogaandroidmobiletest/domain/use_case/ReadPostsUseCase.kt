package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post
import com.rogergcc.zemogaandroidmobiletest.domain.repository.PostRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ReadPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke(): Flow<Resource<List<Post>>> {
        return readPosts().map {
            when (it) {
//                is Resource.Loading ->{
//                    Resource.Loading()
//                }
                is Resource.Success -> {
                    Resource.Success(data = orderPostsFavourites(it.data!!))
                }
                else -> {
                    it
                }
            }
        }
    }

    private fun readPosts(): Flow<Resource<List<Post>>> {
        return postRepository.getPosts()
    }

    private fun orderPostsFavourites(posts: List<Post>): List<Post> {
        return posts.sortedByDescending { it.isFavourite }
    }

}