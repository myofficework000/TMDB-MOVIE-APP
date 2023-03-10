package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.remote.data.MovieDetailResponse
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingMovie
import com.example.tmdbmovieapp.model.remote.data.upcoming.UpcomingResponse
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
    val upComingmovie = localRepository.getUpComingMovies()

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

    //override fun getUpComingMovie() = remoteRepository.loadUpcomingMovies()
    override fun getUpComingMovie() {
        remoteRepository.loadUpcomingMovies().enqueue(object : Callback<UpcomingResponse> {
            override fun onResponse(
                call: Call<UpcomingResponse>,
                response: Response<UpcomingResponse>
            ) {
                response.body()?.let {
                    localRepository.saveUpComingMovies(
                        (it.results.map{
                            result -> result.toLocal(true)
                        })
                    )
                }
            }

            override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {}
        })
    }

    override fun getTrendingMovie(): LiveData<List<TrendingMovie>> {
        updateTrendingMovie()
        return localRepository.getTrendingMovie()
    }
    

}