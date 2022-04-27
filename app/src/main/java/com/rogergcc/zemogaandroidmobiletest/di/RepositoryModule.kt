package com.rogergcc.zemogaandroidmobiletest.di

import com.rogergcc.zemogaandroidmobiletest.data.local.PostDatabase
import com.rogergcc.zemogaandroidmobiletest.data.remote.webservice.CommentApi
import com.rogergcc.zemogaandroidmobiletest.data.remote.webservice.PostApi
import com.rogergcc.zemogaandroidmobiletest.data.remote.webservice.UserApi
import com.rogergcc.zemogaandroidmobiletest.data.repository.CommentRepositoryImpl
import com.rogergcc.zemogaandroidmobiletest.data.repository.PostRepositoryImpl
import com.rogergcc.zemogaandroidmobiletest.data.repository.UserRepositoryImpl
import com.rogergcc.zemogaandroidmobiletest.domain.repository.CommentRepository
import com.rogergcc.zemogaandroidmobiletest.domain.repository.PostRepository
import com.rogergcc.zemogaandroidmobiletest.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePostRepository(api: PostApi, db: PostDatabase): PostRepository {
        return PostRepositoryImpl(api = api, dao = db.postDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi, db: PostDatabase): UserRepository {
        return UserRepositoryImpl(api = api, dao = db.userDao)
    }

    @Provides
    @Singleton
    fun provideCommentRepository(api: CommentApi, db: PostDatabase): CommentRepository {
        return CommentRepositoryImpl(api = api, dao = db.commentDao)
    }

}