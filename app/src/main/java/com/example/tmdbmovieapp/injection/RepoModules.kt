package com.example.tmdbmovieapp.injection

import com.example.tmdbmovieapp.model.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModules {
    @Binds abstract fun bindRepository(impl: Repository): IRepository
    @Binds abstract fun bindLocalRepository(impl: LocalRepository): ILocalRepository
    @Binds abstract fun bindRemoteRepository(impl: RemoteRepository): IRemoteRepository
}