package com.rogergcc.zemogaandroidmobiletest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rogergcc.zemogaandroidmobiletest.data.local.dao.CommentDao
import com.rogergcc.zemogaandroidmobiletest.data.local.dao.PostDao
import com.rogergcc.zemogaandroidmobiletest.data.local.dao.UserDao
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.CommentEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.PostEntity
import com.rogergcc.zemogaandroidmobiletest.data.local.entity.UserEntity

@Database(
    entities = [PostEntity::class,
        UserEntity::class,
        CommentEntity::class],
    version = 1,
)
@TypeConverters(Converters::class)
abstract class PostDatabase : RoomDatabase() {

    abstract val postDao: PostDao
    abstract val userDao: UserDao
    abstract val commentDao: CommentDao

}