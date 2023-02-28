package com.example.tmdbmovieapp.model.remote

import com.example.tmdbmovieapp.model.remote.Constant.BASE_URL
import com.example.tmdbmovieapp.model.remote.Constant.TOKEN_JOSH
import com.example.tmdbmovieapp.model.remote.data.ApiLatestMovie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {

    private lateinit var retrofit: Retrofit
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun getRetrofit(): Retrofit {
        if (!this::retrofit.isInitialized) {

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor())
                .addInterceptor(loggingInterceptor)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        return retrofit
    }

    val instanceLatestMovie: ApiLatestMovie by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(OkHttpInterceptors.APIKey(TOKEN_JOSH))
                    .addInterceptor(loggingInterceptor)
                    .build() )
            .build()
            .create(ApiLatestMovie::class.java)
    }
}