package com.rogergcc.zemogaandroidmobiletest.presentation.screen.post_detail_screen.components.comments_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogergcc.zemogaandroidmobiletest.R
import com.rogergcc.zemogaandroidmobiletest.domain.model.Comment

class CommentAdapter(
    val comments: List<Comment>
) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CommentViewHolder(
            layoutInflater.inflate(R.layout.item_comment, parent, false))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val item = comments[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}