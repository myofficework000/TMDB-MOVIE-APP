package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.remote.data.Movie

class Repository(
    val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    override val searchedNews: MutableLiveData<List<Movie>>
) : IRepository {
    override fun getLatestMovie() = remoteRepository.getLatestMovie()

    override val isProcessing = MutableLiveData<Boolean>()

}