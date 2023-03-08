package com.example.tmdbmovieapp.model.remote

import com.example.tmdbmovieapp.model.remote.data.MovieDetailResponse
import com.example.tmdbmovieapp.model.remote.Constant.END_POINT_UPCOMING_MOVIES
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.example.tmdbmovieapp.model.remote.data.upcoming.UpcomingResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

/*    @GET(END_POINT)
    fun getLatestNews(): Call<NewsResponse>

    @GET(END_POINT_SEARCH)
    fun searchNews(
        @Query("keywords") keywords: String,
        @Query("start_date") start_date: String,
        @Query("end_date") end_date: String,
        @Query("category") category: String? = null,
        @Query("country") country: String? = null,
        @Query("language") language: String? = null
    ): Call<NewsResponse>*/

    @GET(Constant.END_POINT_MOVIE_DETAIL)
    fun getMovieDetail(
        @Path(Constant.END_POINT_MOVIE_DETAIL_ARG_1) movieId: Int
    ): Call<MovieDetailResponse>
    @GET(END_POINT_UPCOMING_MOVIES)
    fun getUpComingMovies(
        @Query("country") country : String? = null,
        @Query("page") page : Int? = null
    ): Call<UpcomingResponse>



}