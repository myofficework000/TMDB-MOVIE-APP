package com.example.tmdbmovieapp.viewmodel

import android.app.Application
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.example.tmdbmovieapp.model.remote.data.latestmovie.LatestMovieResponse
import com.example.tmdbmovieapp.model.repository.LocalRepository
import com.example.tmdbmovieapp.model.repository.RemoteRepository
import com.example.tmdbmovieapp.model.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel(
    application: Application,
    private val db: AppDatabase = AppDatabase.getInstance(application),
    private val repository: Repository = Repository(db)
) : AndroidViewModel(application), Observable {
    val latestMovie = repository.latestMovie
    val movieDetail = repository.movieDetail

    fun getTopRatedMovies() {

    }

    fun getPopularMovies() {

    }

    fun getUpcomingMovies() {

    }

    fun getLatestMovies() = latestMovie.also { repository.getLatestMovie() }

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
}