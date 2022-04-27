package com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.post_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogergcc.zemogaandroidmobiletest.R

import com.rogergcc.zemogaandroidmobiletest.domain.model.Post

class PostAdapter(
    val posts : List<Post>,
    private val postItemListener: PostItemListener
) : RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PostViewHolder(
            layoutInflater.inflate(R.layout.item_post, parent, false),
        postItemListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = posts[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}