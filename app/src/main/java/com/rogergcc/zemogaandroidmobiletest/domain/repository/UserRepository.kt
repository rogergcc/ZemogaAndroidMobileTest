package com.rogergcc.zemogaandroidmobiletest.domain.repository

import com.rogergcc.zemogaandroidmobiletest.domain.model.User
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUser(userId: Int): Flow<Resource<User>>
}