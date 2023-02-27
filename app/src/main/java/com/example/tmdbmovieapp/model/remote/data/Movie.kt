package com.example.tmdbmovieapp.model.remote.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Movie")
data class Movie(
//    val adult: Boolean,
//    val backdrop_path: Any,
//    val belongs_to_collection: Any,
//    val budget: Int,
//    val genres: List<Any>,
//    val homepage: String,
    @PrimaryKey
    val id: Int,
//    val imdb_id: Any,
//
//    @ColumnInfo(name = "original_language")
//    @SerializedName("original_language")
//    val originalLanguage: String,
//
//    val original_title: String,
//    val overview: String,
//    val popularity: Double,
//    val poster_path: Any,
//    val production_companies: List<Any>,
//    val production_countries: List<Any>,
//    val release_date: String,
//    val revenue: Int,
//    val runtime: Int,
//    val spoken_languages: List<Any>,
//    val status: String,
//    val tagline: String,
    val title: String,
//    val video: Boolean,
//    val vote_average: Double,
//    val vote_count: Int
)
