package com.example.tmdbmovieapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbmovieapp.model.local.data.Movie
import com.example.tmdbmovieapp.model.remote.Constant

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveMovies(movies: List<Movie>): List<Long>

    @Query("SELECT * FROM ${Constant.TABLE_MOVIE} WHERE isUpcoming = 1")
    fun getUpcomingMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM ${Constant.TABLE_MOVIE} WHERE isTopRated = 1")
    fun getTopRatedMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM ${Constant.TABLE_MOVIE} WHERE isSearched = 1")
    fun getSearchedMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM MOVIE where id IN (:ids)")
    fun deleteSearchedMovies(ids: LongArray)   // Todo work
}