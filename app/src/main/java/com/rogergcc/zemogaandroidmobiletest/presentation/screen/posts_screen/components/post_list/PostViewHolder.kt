package com.rogergcc.zemogaandroidmobiletest.presentation.screen.posts_screen.components.post_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rogergcc.zemogaandroidmobiletest.databinding.ItemPostBinding
import com.rogergcc.zemogaandroidmobiletest.domain.model.Post

class PostViewHolder(
    itemView: View,
    private val postItemListener: PostItemListener
) : RecyclerView.ViewHolder(itemView) {

    val binding = ItemPostBinding.bind(itemView)

    fun render(post: Post) {
        if (post.isFavourite == 1) {
            binding.ivFavIcon.visibility = View.VISIBLE

        }else{

            binding.ivFavIcon.visibility=View.GONE
        }

        binding.tvTitle.text = post.title
        binding.root.setOnClickListener {
            postItemListener.onItemClick(post)
        }
    }

}