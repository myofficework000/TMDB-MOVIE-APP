package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.remote.data.Movie

class Repository(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
) : IRepository {
    override fun getLatestMovie() = remoteRepository.getLatestMovie()

    override val searchedNews = MutableLiveData<List<Movie>>()
    override val isProcessing = MutableLiveData<Boolean>()
}