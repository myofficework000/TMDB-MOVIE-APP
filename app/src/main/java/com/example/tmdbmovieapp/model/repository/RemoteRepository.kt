package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.remote.ApiService
import com.example.tmdbmovieapp.model.remote.RetrofitBuilder
import com.example.tmdbmovieapp.model.remote.data.ApiLatestMovie

class RemoteRepository(
    private val apiService: ApiService,
    private val apiLatestMovie: ApiLatestMovie
) {
    fun getLatestMovie() = apiLatestMovie.getLatestMovie()
}