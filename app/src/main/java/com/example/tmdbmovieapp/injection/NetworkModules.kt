package com.example.tmdbmovieapp.injection

import com.example.tmdbmovieapp.model.remote.ApiService
import com.example.tmdbmovieapp.model.remote.Constant
import com.example.tmdbmovieapp.model.remote.OkHttpInterceptors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {
    @Provides
    fun provideOkhttp() = OkHttpClient.Builder()
        .addInterceptor(OkHttpInterceptors.APIKey(Constant.TOKEN_ALEX))
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Provides
    fun provideApi(
        client: OkHttpClient
    ): ApiService = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .build()
        .create(ApiService::class.java)
}