package com.example.tmdbmovieapp.viewmodel

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.repository.Repository

class MovieListViewModel(
    application: Application,
    private val db: AppDatabase = AppDatabase.getInstance(application),
    private val repository: Repository = Repository(db)
) : AndroidViewModel(application), Observable {
    val latestMovie = repository.latestMovie
    val movieDetail = repository.movieDetail
    val upComingMovies = repository.upComingMovie
    val topRatedMovies = repository.topRatedMovie
    val searchedMovieLiveData = repository.searchedMovies

    fun getUpcomingMovies() = upComingMovies.also { repository.getUpComingMovie() }

    fun getTrendingMovies() = topRatedMovies.also { repository.getTopRatedMovie() }

    fun getLatestMovies() = latestMovie.also { repository.getLatestMovie() }

    fun getSearchedMovies(searchText: String) =
        searchedMovieLiveData.also { repository.searchMovie(searchText) }

    fun getMovieDetail(movieId: Int) = movieDetail.also { repository.getMovieDetail(movieId) }

    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    override fun onCleared() {
        super.onCleared()
        repository.compositeDisposable.dispose()
    }
}