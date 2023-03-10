package com.example.tmdbmovieapp.model.remote.data.upcoming

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.data.MovieResponse
import com.google.gson.annotations.SerializedName

@Entity(tableName = "UpcomingMovie")
data class MoviesListResponse(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
//    @SerializedName("dates")
//    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResponse>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)