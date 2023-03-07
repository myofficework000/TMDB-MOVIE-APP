package com.example.tmdbmovieapp.model.remote.data.latestmovie


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.local.data.MovieGenre
import com.google.gson.annotations.SerializedName

@Entity(tableName = "LatestMovie")
data class LatestMovieResponse(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("genres")
    val genres: List<MovieGenre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)