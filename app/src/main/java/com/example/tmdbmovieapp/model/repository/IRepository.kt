package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.MutableLiveData

interface IRepository {
    fun getMovieDetail(movieId: Int)
    fun getLatestMovie()
    val isProcessing: MutableLiveData<Boolean>
    fun getUpComingMovie()
    fun getTopRatedMovie()
    fun getPopularMovie()
    fun searchMovie(movieName: String)
    fun onCleared()
}