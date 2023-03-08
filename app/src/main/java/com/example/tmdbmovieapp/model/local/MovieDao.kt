package com.example.tmdbmovieapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tmdbmovieapp.model.local.data.*
import com.example.tmdbmovieapp.model.remote.Constant

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLatestMovie(data: Movie): Long
    @Query("SELECT * FROM ${Constant.TABLE_MOVIE}")
    fun getLatestMovie(): LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovieDetail(data: List<MovieDetail>): List<Long>
    @Query("select * from ${Constant.TABLE_MOVIE_DETAIL} where id = :movieId")
    fun getMovieDetailById(movieId: Int): LiveData<MovieDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovieGenre(data: List<MovieGenre>)
    @Query("select * from ${Constant.TABLE_MOVIE_GENRE} where id = :genreId")
    fun getMovieGenreById(genreId: Int): List<MovieGenre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProductionCompany(data: List<ProductionCompany>)
    @Query("select * from ${Constant.TABLE_PRODUCTION_COMPANY} where id = :companyId")
    fun getProductionCompanyById(companyId: Int): List<ProductionCompany>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProductionCountry(data: List<ProductionCountry>)
    @Query("select * from ${Constant.TABLE_PRODUCTION_COUNTRY} where iso31661 = :countryIso")
    fun getProductionCountryById(countryIso: Int): List<ProductionCountry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSpokenLanguage(data: List<SpokenLanguage>)
    @Query("select * from ${Constant.TABLE_SPOKEN_LANGUAGE} where iso6391 = :languageIso")
    fun getSpokenLanguageById(languageIso: Int): List<SpokenLanguage>
    @Query("SELECT * FROM Movie")
    fun getNews(): LiveData<List<Movie>>

}