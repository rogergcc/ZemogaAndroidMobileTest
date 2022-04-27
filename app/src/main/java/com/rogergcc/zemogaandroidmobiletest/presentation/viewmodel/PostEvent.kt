package com.rogergcc.zemogaandroidmobiletest.presentation.viewmodel

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post

sealed class PostEvent{
    object LoadPostList : PostEvent()
    data class ClickOnPost(val post: Post) : PostEvent()
    data class LoadPostAuthor(val userId: Int) : PostEvent()
    data class LoadPostComments(val postId: Int) : PostEvent()
    data class ToggleFavouritePost(val postId: Int) : PostEvent()
    data class DeletePost(val post: Post) : PostEvent()
    object DeleteAllPosts : PostEvent()
    object RefreshPostList : PostEvent()

}
