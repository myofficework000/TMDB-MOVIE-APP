package com.example.tmdbmovieapp.model.repository

import com.example.tmdbmovieapp.model.remote.ApiService
import com.example.tmdbmovieapp.model.remote.Constant.TOKEN_ALEX
import com.example.tmdbmovieapp.model.remote.RetrofitBuilder
import com.example.tmdbmovieapp.model.remote.data.ApiLatestMovie
import com.example.tmdbmovieapp.model.remote.data.MovieDetailResponse
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.example.tmdbmovieapp.model.remote.data.upcoming.MoviesListResponse
import io.reactivex.Single
import retrofit2.create
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val apiService: ApiService
): IRemoteRepository {
    override fun getLatestMovie() = apiService.getLatestMovie()
    override fun getMovieDetail(movieId: Int) = apiService.getMovieDetail(movieId)
    override fun loadUpcomingMovies() = apiService.getUpComingMovies()

    override fun loadTopRatedMovies() = apiService.getTopRatedMovies()

    override fun searchMovie(searchText: String) = apiService.getMovieSearch(searchText)
}

interface IRemoteRepository {
    fun getLatestMovie(): Single<MovieResponse>
    fun getMovieDetail(movieId: Int): Single<MovieDetailResponse>
    fun loadUpcomingMovies(): Single<MoviesListResponse>
    fun loadTopRatedMovies(): Single<MoviesListResponse>
    fun searchMovie(searchText: String): Single<MoviesListResponse>
}