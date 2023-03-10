package com.example.tmdbmovieapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbmovieapp.model.remote.Constant
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingMovie

@Dao
interface TrendingMovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTrendingMovies(movies: List<TrendingMovie>) : List<Long>

    @Query("SELECT * FROM ${Constant.TABLE_TRENDING_MOVIE}")
    fun getTrendingMovies(): List<TrendingMovie>
}