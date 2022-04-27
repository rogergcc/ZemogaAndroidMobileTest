package com.rogergcc.zemogaandroidmobiletest.data.repository



import com.rogergcc.zemogaandroidmobiletest.data.local.dao.CommentDao
import com.rogergcc.zemogaandroidmobiletest.data.remote.webservice.CommentApi
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment
import com.rogergcc.zemogaandroidmobiletest.domain.repository.CommentRepository
import com.rogergcc.zemogaandroidmobiletest.util.ErrorType
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CommentRepositoryImpl (
    private val api: CommentApi,
    private val dao: CommentDao
) : CommentRepository {
    override fun getCommentsOfPost(postId: Int): Flow<Resource<List<Comment>>> {
        return return flow {
            emit(Resource.Loading<List<Comment>>()) //Start loading
            val commentEntity = dao.getCommentByPostId(postId = postId)
            if (!commentEntity.isEmpty()) {
                emit(Resource.Success(data = commentEntity.map { it.toComment() }))
            } else {
                try {
                    val commentDto = api.getCommentByPostId(postId = postId)
                    dao.insertComments(commentDto.map { it.toCommentEntity() })
                    emit(Resource.Success(data = commentDto.map { it.toComment() }))
                } catch (e : HttpException){
                    emit(Resource.Error(
                        message = "Something went wrong!",
                        errorType = ErrorType.EMPTY_DATA
                    ))
                } catch (e : IOException) {
                    emit(Resource.Error<List<Comment>>(
                        message = "Unable to reach the server",
                        errorType = ErrorType.EMPTY_DATA
                    ))
                }
            }
        }
    }
}