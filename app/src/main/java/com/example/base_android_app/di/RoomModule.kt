package com.example.base_android_app.di

import android.content.Context
import androidx.room.Room
import com.example.base_android_app.room.ExampleDatabase
import com.example.base_android_app.room.dao.ExampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideExampleDatabase(@ApplicationContext context: Context): ExampleDatabase {
        return Room.databaseBuilder(
            context,
            ExampleDatabase::class.java,
            ExampleDatabase.DB_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideExampleDao(exampleDatabase: ExampleDatabase): ExampleDao{
        return exampleDatabase.exampleDao()
    }
}