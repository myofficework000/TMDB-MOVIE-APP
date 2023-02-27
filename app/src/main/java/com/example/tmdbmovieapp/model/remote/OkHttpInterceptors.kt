package com.example.tmdbmovieapp.model.remote

import okhttp3.Interceptor
import okhttp3.Response

object OkHttpInterceptors {
    class APIKey(
        private val apiKey: String
    ) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val currentUrl = chain.request().url
            val newUrl = currentUrl.newBuilder().addQueryParameter("api_key", apiKey).build()
            val currentRequest = chain.request().newBuilder()
            val newRequest = currentRequest.url(newUrl).build()
            return chain.proceed(newRequest)
        }
    }
}