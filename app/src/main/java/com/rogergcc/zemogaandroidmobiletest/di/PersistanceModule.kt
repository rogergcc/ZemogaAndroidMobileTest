package com.rogergcc.zemogaandroidmobiletest.di

import android.app.Application
import androidx.room.Room

import com.google.gson.Gson
import com.rogergcc.zemogaandroidmobiletest.data.local.Converters
import com.rogergcc.zemogaandroidmobiletest.data.local.PostDatabase
import com.rogergcc.zemogaandroidmobiletest.data.utils.GsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistanceModule {

    @Provides
    @Singleton
    fun provideCacheDatabase(app: Application): PostDatabase {
        return Room.databaseBuilder(
            app, PostDatabase::class.java, "post_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

}