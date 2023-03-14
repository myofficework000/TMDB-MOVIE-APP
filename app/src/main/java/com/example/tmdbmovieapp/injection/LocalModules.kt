package com.example.tmdbmovieapp.injection

import android.content.Context
import androidx.room.Room
import com.example.tmdbmovieapp.model.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalModules {
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "movieDB"
    )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
}