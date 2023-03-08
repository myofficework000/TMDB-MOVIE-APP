package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.local.data.Movie
import com.example.tmdbmovieapp.model.local.data.MovieDetail

class LocalRepository(private val appDatabase: AppDatabase) {

    fun getLatestMovie() = appDatabase.getMovieDao().getLatestMovie()
    fun saveLatestMovie(movie: Movie) = appDatabase.getMovieDao().saveLatestMovie(movie)

    fun saveMovieDetail(data: List<MovieDetail>) = appDatabase.getMovieDao().saveMovieDetail(data)
    fun getMovieDetailById(movieId: Int) = appDatabase.getMovieDao().getMovieDetailById(movieId)
    fun getUpComingMovies() = appDatabase.getUpComingMovieDao().getMovies()

    fun saveUpComingMovies(movies: List<Movie>) = appDatabase.getUpComingMovieDao().saveMovies(movies)
}