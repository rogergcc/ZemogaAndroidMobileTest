package com.rogergcc.zemogaandroidmobiletest.presentation.screen.post_detail_screen.components.comments_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rogergcc.zemogaandroidmobiletest.databinding.ItemCommentBinding
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment

class CommentViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    val binding = ItemCommentBinding.bind(itemView)

    fun render(comment: Comment) {
        binding.tvBody.text = comment.body
        binding.tvTitle.text = comment.name
        binding.tvAuthor.text = comment.email
    }

}