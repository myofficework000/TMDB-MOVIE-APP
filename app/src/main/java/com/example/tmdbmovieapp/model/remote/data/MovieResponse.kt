package com.example.tmdbmovieapp.model.remote.data


import com.example.tmdbmovieapp.model.local.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double

) {
    fun toLocal(isUpcoming: Boolean = false, isTopRated: Boolean = false, isSearch:Boolean) = Movie(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds ?: listOf(),
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        isUpcoming = isUpcoming,
        isTopRated = isTopRated
    )
}