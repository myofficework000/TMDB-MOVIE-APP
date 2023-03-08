package com.example.tmdbmovieapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbmovieapp.model.local.data.Movie
import com.example.tmdbmovieapp.model.remote.Constant

@Dao
interface UpcomingMoiveDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveMovies(movies: List<Movie>) : List<Long>

    @Query("SELECT * FROM ${Constant.TABLE_MOVIE} WHERE isUpcoming = 1")
    fun getMovies(): LiveData<List<Movie>>

}