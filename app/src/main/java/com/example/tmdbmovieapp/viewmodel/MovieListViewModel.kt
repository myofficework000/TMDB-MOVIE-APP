package com.example.tmdbmovieapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.local.AppDatabase
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
    private val localRepository: LocalRepository = LocalRepository(db),
    private val remoteRepository: RemoteRepository = RemoteRepository(),
    private val repository: Repository = Repository(localRepository, remoteRepository)
) : AndroidViewModel(application) {
    private val _latestMovie = MutableLiveData<LatestMovieResponse>()
    val latestMovie: LiveData<LatestMovieResponse> get() = _latestMovie

    fun getTopRatedMovies() {

    }

    fun getPopularMovies() {

    }

    fun getUpcomingMovies() {

    }

    fun getLatestMovies() {
        repository.getLatestMovie().enqueue(object : Callback<LatestMovieResponse>{
            override fun onResponse(
                call: Call<LatestMovieResponse>,
                response: Response<LatestMovieResponse>
            ) { response.body()?.let { _latestMovie.value = it } }

            override fun onFailure(call: Call<LatestMovieResponse>, t: Throwable) {}
        })
    }
}