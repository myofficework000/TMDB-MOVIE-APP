package com.example.tmdbmovieapp.model.remote

import com.example.tmdbmovieapp.model.remote.Constant.END_POINT_TOP_RATED_MOVIES
import com.example.tmdbmovieapp.model.remote.data.MovieDetailResponse
import com.example.tmdbmovieapp.model.remote.Constant.END_POINT_UPCOMING_MOVIES
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.example.tmdbmovieapp.model.remote.data.upcoming.MoviesListResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET(Constant.END_POINT_MOVIE_DETAIL)
    fun getMovieDetail(
        @Path(Constant.END_POINT_MOVIE_DETAIL_ARG_1) movieId: Int
    ): Single<MovieDetailResponse>
    @GET(END_POINT_UPCOMING_MOVIES)
    fun getUpComingMovies(
        @Query("country") country : String? = null,
        @Query("page") page : Int? = null
    ): Single<MoviesListResponse>

    @GET(END_POINT_TOP_RATED_MOVIES)
    fun getTopRatedMovies(
        @Query("country") country : String? = null,
        @Query("page") page : Int? = null
    ): Single<MoviesListResponse>

    @GET(Constant.END_POINT_LATEST_MOVIES)
    fun getLatestMovie(): Single<MovieResponse>
}