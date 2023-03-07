package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.remote.data.MovieDetailResponse
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(
    private val appDatabase: AppDatabase,
    private val localRepository: LocalRepository = LocalRepository(appDatabase),
    private val remoteRepository: RemoteRepository = RemoteRepository()
) : IRepository {
    private val _latestMovie = MutableLiveData<MovieResponse>()
    val latestMovie: LiveData<MovieResponse> get() = _latestMovie
    val movieDetail = localRepository.getMovieDetailById(-1)

    override fun getMovieDetail(movieId: Int) {
        remoteRepository.getMovieDetail(movieId).enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                response.body()?.let {
                    localRepository.saveMovieDetail(
                        listOf(it.toLocal(appDatabase.getMovieDao()))
                    )
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {}
        })
    }

    override fun getLatestMovie() {
        remoteRepository.getLatestMovie().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.let { _latestMovie.value = it }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {}
        })
    }
    override val isProcessing = MutableLiveData<Boolean>()
}