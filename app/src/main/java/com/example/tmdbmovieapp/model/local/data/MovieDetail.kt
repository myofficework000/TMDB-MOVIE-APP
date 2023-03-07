package com.example.tmdbmovieapp.model.local.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.Constant

@Entity(tableName = Constant.TABLE_MOVIE_DETAIL)
data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String?,
    val budget: Int,
    val genres: List<Int>,
    val homepage: String?,
    @PrimaryKey
    val id: Int,
    val imdbId: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    val posterPath: String?,
    val productionCompanies: List<Int>,
    val productionCountries: List<String>,
    val releaseDate: Long,
    val revenue: Int,
    val runtime: Int?,
    val spokenLanguages: List<String>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)