package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.remote.ApiService
import com.example.tmdbmovieapp.model.remote.RetrofitBuilder
import com.example.tmdbmovieapp.model.remote.data.ApiLatestMovie
import retrofit2.create

class RemoteRepository(
    private val apiService: ApiService = RetrofitBuilder.getRetrofit().create(ApiService::class.java),
    private val apiLatestMovie: ApiLatestMovie = RetrofitBuilder.instanceLatestMovie
) {
    fun getLatestMovie() = apiLatestMovie.getLatestMovie()
    fun getMovieDetail(movieId: Int) = apiService.getMovieDetail(movieId)
}