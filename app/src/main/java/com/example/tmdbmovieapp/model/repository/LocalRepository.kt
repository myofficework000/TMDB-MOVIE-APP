package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.local.data.Movie
import com.example.tmdbmovieapp.model.local.data.MovieDetail
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingMovie
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingResponse

class LocalRepository(private val appDatabase: AppDatabase) {

    fun getLatestMovie() = appDatabase.getMovieDao().getLatestMovie()
    fun saveLatestMovie(movie: Movie) = appDatabase.getMovieDao().saveLatestMovie(movie)

    fun saveMovieDetail(data: List<MovieDetail>) = appDatabase.getMovieDao().saveMovieDetail(data)
    fun getMovieDetailById(movieId: Int) = appDatabase.getMovieDao().getMovieDetailById(movieId)
    fun getUpComingMovies() = appDatabase.getUpComingMovieDao().getMovies()

    fun saveUpComingMovies(movies: List<Movie>) = appDatabase.getUpComingMovieDao().saveMovies(movies)

    fun saveTrendingMovie(movies: List<TrendingMovie>) = appDatabase.getTrendingMovieDao().saveTrendingMovies(movies)

    fun getTrendingMovie() = appDatabase.getTrendingMovieDao().getTrendingMovies()
}