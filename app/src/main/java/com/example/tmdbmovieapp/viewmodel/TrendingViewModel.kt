package com.example.tmdbmovieapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingMovie
import com.example.tmdbmovieapp.model.repository.IRepository

class TrendingViewModel(application: Application, val repository: IRepository): AndroidViewModel(application) {
    val trendingMovies: LiveData<List<TrendingMovie>> = repository.getTrendingMovie()

    fun refreshTrendingMovies() {
        repository.updateTrendingMovie()
    }
}