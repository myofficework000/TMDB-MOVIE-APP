package com.example.tmdbmovieapp.model.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.Constant
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constant.TABLE_MOVIE)
data class Movie(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>?,
    @PrimaryKey val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val isUpcoming: Boolean
)
