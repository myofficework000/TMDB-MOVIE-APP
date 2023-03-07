package com.example.tmdbmovieapp.model.remote.data

import com.example.tmdbmovieapp.model.remote.Constant
import retrofit2.Call
import retrofit2.http.GET

interface ApiLatestMovie {
    @GET(Constant.END_POINT_LATEST_MOVIES)
    fun getLatestMovie(): Call<MovieResponse>
}