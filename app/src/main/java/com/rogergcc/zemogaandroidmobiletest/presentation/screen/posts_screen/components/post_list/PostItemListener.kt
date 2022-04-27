package com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.post_list

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post

interface PostItemListener {

    fun onItemClick(post: Post)

}