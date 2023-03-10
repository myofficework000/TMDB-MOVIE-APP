package com.example.tmdbmovieapp.model.remote

import com.example.tmdbmovieapp.model.remote.Constant.BASE_URL
import com.example.tmdbmovieapp.model.remote.Constant.TOKEN_ALEX
import com.example.tmdbmovieapp.model.remote.Constant.TOKEN_JOSH
import com.example.tmdbmovieapp.model.remote.data.ApiLatestMovie
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {

    val instanceLatestMovie: ApiService by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(OkHttpInterceptors.APIKey(TOKEN_ALEX))
            .addInterceptor(loggingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(OkHttpInterceptors.APIKey(TOKEN_JOSH))
                    .addInterceptor(loggingInterceptor)
                    .build()
            )
            .build()
            .create(ApiService::class.java)
    }
}