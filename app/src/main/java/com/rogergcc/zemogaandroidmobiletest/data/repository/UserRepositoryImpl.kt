package com.rogergcc.zemogaandroidmobiletest.data.repository


import com.rogergcc.zemogaandroidmobiletest.data.local.dao.UserDao
import com.rogergcc.zemogaandroidmobiletest.data.remote.webservice.UserApi
import com.rogergcc.zemogaandroidmobiletest.domain.model.User
import com.rogergcc.zemogaandroidmobiletest.domain.repository.UserRepository
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImpl (
    private val api: UserApi,
    private val dao: UserDao
) : UserRepository {
    override fun getUser(userId: Int): Flow<Resource<User>> {
        return return flow {
            emit(Resource.Loading<User>()) //Start loading
            val userEntity = dao.getUserById(userId = userId)
            if (userEntity != null) {
                emit(Resource.Success(data = userEntity.toUser()))
            } else {
                try {
                    val userDto = api.getUserById(userId)
                    dao.insertUser(userDto.toUserEntity())
                    emit(Resource.Success(data = userDto.toUser()))
                } catch (e : HttpException){
                    emit(Resource.Error<User>(
                        message = "Something went wrong!"
                    ))
                } catch (e : IOException) {
                    emit(Resource.Error<User>(
                        message = "Unable to reach the server"
                    ))
                }
            }
        }
    }
}