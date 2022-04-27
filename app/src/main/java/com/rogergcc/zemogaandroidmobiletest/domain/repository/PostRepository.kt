package com.rogergcc.zemogaandroidmobiletest.domain.repository

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPosts(): Flow<Resource<List<Post>>>

    fun insertPost(post: Post): Flow<Resource<Post>>

    fun deletePost(post: Post): Flow<Resource<Post>>

    fun deleteAllPosts(): Flow<Resource<Boolean>>

    fun fetchAllPosts(): Flow<Resource<List<Post>>>

}