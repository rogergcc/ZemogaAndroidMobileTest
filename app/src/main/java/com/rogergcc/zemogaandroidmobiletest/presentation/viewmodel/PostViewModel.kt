package com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment
import com.rogergcc.zemogaandroidmobiletest.domain.model.Post
import com.rogergcc.zemogaandroidmobiletest.domain.model.User
import com.rogergcc.zemogaandroidmobiletest.domain.use_case.*
import com.rogergcc.zemogaandroidmobiletest.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val readPostsUseCase: ReadPostsUseCase,
    private val readCommentsUseCase: ReadCommentsUseCase,
    private val readUserInfoUseCase: ReadUserInfoUseCase,
    private val changeFavStatusUseCase: ChangeFavStatusUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val deleteAllPostUseCase: DeleteAllPostUseCase,
    private val refreshPostsUseCase: RefreshPostsUseCase
) : ViewModel() {

    val posts = MutableLiveData<List<Post>>()
    val selectedPost = MutableLiveData<Post>()
    val selectedPostAuthor = MutableLiveData<User?>()
    val selectedPostComments = MutableLiveData<List<Comment>>()
    val deletionSuccess = MutableLiveData<Boolean>(false)

    fun onEvent(event: PostEvent) {
        when(event) {
            is PostEvent.LoadPostList -> {
                readAllPosts()
            }
            is PostEvent.ClickOnPost -> {
                selectedPost.postValue(event.post)
            }
            is PostEvent.LoadPostAuthor -> {
                readAuthorInfoOfPost(event.userId)
            }
            is PostEvent.LoadPostComments -> {
                readAllCommentsOfPost(event.postId)
            }
            is PostEvent.ToggleFavouritePost -> {
                val updatedPost = selectedPost.value!!.copy(isFavourite = 1-selectedPost.value!!.isFavourite)
                changeFavouriteStatusOfPost(updatedPost)
            }
            is PostEvent.DeletePost -> {
                deleteCurrentPost(event.post)
            }
            is PostEvent.DeleteAllPosts -> {
                deleteAllPosts()
            }
            is PostEvent.RefreshPostList -> {
                refreshPosts()
            }
        }
    }


    private fun readAllPosts() {
        readPostsUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    posts.postValue(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    posts.postValue(emptyList())
                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun readAuthorInfoOfPost(userId: Int) {
        readUserInfoUseCase.invoke(userId = userId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    selectedPostAuthor.postValue(result.data)
                }
                is Resource.Error -> {
                    selectedPostAuthor.postValue(null)
                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun readAllCommentsOfPost(postId: Int) {
        readCommentsUseCase.invoke(postId = postId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    selectedPostComments.postValue(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    selectedPostComments.postValue(emptyList())
                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun changeFavouriteStatusOfPost(post: Post) {
        changeFavStatusUseCase.invoke(post).onEach { result ->
            when(result) {
                is Resource.Success -> {

                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun deleteCurrentPost(post: Post) {
        deletePostUseCase.invoke(post).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    deletionSuccess.postValue(true)
                }
                is Resource.Error -> {
                    deletionSuccess.postValue(false)
                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun deleteAllPosts() {
        deleteAllPostUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    posts.postValue(emptyList())
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

    private fun refreshPosts() {
        refreshPostsUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    posts.postValue(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    posts.postValue(emptyList())
                }
                is Resource.Loading -> {

                }
            }
        }.launchIn(viewModelScope)
    }

}