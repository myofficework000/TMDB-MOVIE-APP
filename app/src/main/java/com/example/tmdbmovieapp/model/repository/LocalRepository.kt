package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.local.data.Movie
import com.example.tmdbmovieapp.model.local.data.MovieDetail
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val appDatabase: AppDatabase
): ILocalRepository {
    override fun getLatestMovie() = appDatabase.getMovieDao().getLatestMovie()
    override fun saveLatestMovie(movie: Movie) = appDatabase.getMovieDao().saveLatestMovie(movie)
    override fun saveMovieDetail(data: List<MovieDetail>) = appDatabase.getMovieDao().saveMovieDetail(data)
    override fun getMovieDetailById(movieId: Int) = appDatabase.getMovieDao().getMovieDetailById(movieId)
    override fun getUpComingMovies() = appDatabase.getMoviesDao().getUpcomingMovies()
    override fun saveUpComingMovies(movies: List<Movie>) = appDatabase.getMoviesDao().saveMovies(movies)
    override fun getTopRatedMovies() = appDatabase.getMoviesDao().getTopRatedMovies()
    override fun saveTopRatedMovies(movies: List<Movie>) = appDatabase.getMoviesDao().saveMovies(movies)
    override fun getSearchMovies() = appDatabase.getMoviesDao().getSearchedMovies()
    override fun saveAsSearchMovies(movies: List<Movie>) = appDatabase.getMoviesDao().saveMovies(movies)
    override fun deleteSearchedMovies(ids: LongArray) = appDatabase.getMoviesDao().deleteSearchedMovies(ids)
}

interface ILocalRepository {
    fun getLatestMovie(): LiveData<List<Movie>>
    fun saveLatestMovie(movie: Movie): Long
    fun saveMovieDetail(data: List<MovieDetail>): List<Long>
    fun getMovieDetailById(movieId: Int): LiveData<MovieDetail>
    fun getUpComingMovies(): LiveData<List<Movie>>
    fun saveUpComingMovies(movies: List<Movie>): List<Long>
    fun getTopRatedMovies(): LiveData<List<Movie>>
    fun saveTopRatedMovies(movies: List<Movie>): List<Long>
    fun getSearchMovies(): LiveData<List<Movie>>
    fun saveAsSearchMovies(movies: List<Movie>): List<Long>
    fun deleteSearchedMovies(ids: LongArray)
}
