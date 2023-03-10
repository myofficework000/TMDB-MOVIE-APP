package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.remote.ApiService
import com.example.tmdbmovieapp.model.remote.Constant.TOKEN_ALEX
import com.example.tmdbmovieapp.model.remote.RetrofitBuilder
import com.example.tmdbmovieapp.model.remote.data.ApiLatestMovie
import retrofit2.create

class RemoteRepository(
    private val apiService: ApiService =  RetrofitBuilder.instanceLatestMovie) {
    fun getLatestMovie() = apiService.getLatestMovie()
    fun getMovieDetail(movieId: Int) = apiService.getMovieDetail(movieId)
    fun loadUpcomingMovies() = apiService.getUpComingMovies()

    fun loadTopRatedMovies() = apiService.getTopRatedMovies()
}