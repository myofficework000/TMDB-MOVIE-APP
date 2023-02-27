package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.remote.data.Movie
import com.example.tmdbmovieapp.model.remote.data.latestmovie.LatestMovieResponse
import retrofit2.Call

interface IRepository {

    fun getLatestMovie(): Call<LatestMovieResponse>
    val isProcessing: MutableLiveData<Boolean>
    val searchedNews: MutableLiveData<List<Movie>>
}