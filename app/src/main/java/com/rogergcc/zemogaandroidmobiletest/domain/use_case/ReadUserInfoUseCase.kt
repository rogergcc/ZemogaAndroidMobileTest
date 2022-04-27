package com.rogergcc.zemogaandroidmobiletest.domain.use_case

import com.rogergcc.zemogaandroidmobiletest.domain.model.User
import com.rogergcc.zemogaandroidmobiletest.domain.repository.UserRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadUserInfoUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(userId: Int): Flow<Resource<User>> {
        return readUserInfo(userId)
    }

    private fun readUserInfo(userId: Int): Flow<Resource<User>> {
        return userRepository.getUser(userId)
    }

}