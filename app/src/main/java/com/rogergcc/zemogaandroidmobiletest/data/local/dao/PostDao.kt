package com.rogergcc.zemogaandroidmobiletest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.PostEntity

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(post: List<PostEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: PostEntity)

    @Query("DELETE FROM postentity WHERE id = :postId")
    suspend fun deletePost(postId : Int)

    @Query("DELETE FROM postentity")
    suspend fun deleteAllPosts()

    @Query("DELETE FROM postentity WHERE id IN(:postsId)")
    suspend fun deletePostList(postsId : List<Int>)

    @Query("SELECT * FROM postentity")
    suspend fun getAllPosts() : List<PostEntity>
}