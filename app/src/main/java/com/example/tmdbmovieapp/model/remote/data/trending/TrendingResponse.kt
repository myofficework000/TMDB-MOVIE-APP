package com.example.tmdbmovieapp.model.remote.data.trending

import com.google.gson.annotations.SerializedName

data class TrendingResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TrendingMovie>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)