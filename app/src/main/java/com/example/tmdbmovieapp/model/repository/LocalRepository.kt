package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.remote.data.Movie

class LocalRepository(private val appDatabase: AppDatabase) {

    fun getLatestNews() = appDatabase.getMovieDao().getNews()

    fun saveNews(movie: List<Movie>) = appDatabase.getMovieDao().saveNews(movie)
}