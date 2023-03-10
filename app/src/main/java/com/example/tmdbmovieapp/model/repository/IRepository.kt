package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.example.tmdbmovieapp.model.remote.data.latestmovie.LatestMovieResponse
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingMovie
import com.example.tmdbmovieapp.model.remote.data.upcoming.UpcomingResponse
import retrofit2.Call

interface IRepository {
    fun getMovieDetail(movieId: Int)
    fun getLatestMovie()
    val isProcessing: MutableLiveData<Boolean>

    fun getUpComingMovie()

    fun getTrendingMovie(): LiveData<List<TrendingMovie>>

    fun updateTrendingMovie()
}