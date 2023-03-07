package com.example.tmdbmovieapp.model.remote.data


import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.local.MovieDao
import com.example.tmdbmovieapp.model.local.data.*
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class MovieDetailResponse(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<MovieGenre>,
    @SerializedName("homepage")
    val homepage: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String,
    @SerializedName("tagline")
    val tagline: String?,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) {
    fun toLocal(dao: MovieDao) = MovieDetail(
        adult = adult,
        backdropPath = backdropPath,
        budget = budget,
        genres = genres
            .apply { dao.saveMovieGenre(this) }
            .map { it.id },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies
            .apply { dao.saveProductionCompany(this) }
            .map { it.id },
        productionCountries = productionCountries
            .apply { dao.saveProductionCountry(this) }
            .map { it.iso31661 },
        releaseDate = LocalDate.parse(releaseDate).toEpochDay() ,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages
            .apply { dao.saveSpokenLanguage(this) }
            .map { it.iso6391 },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}