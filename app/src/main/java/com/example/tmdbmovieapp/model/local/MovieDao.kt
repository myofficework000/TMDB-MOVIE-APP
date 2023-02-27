package com.example.tmdbmovieapp.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbmovieapp.model.remote.data.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveNews(news: List<Movie>): List<Long>

    @Query("SELECT * FROM Movie")
    fun getNews(): LiveData<List<Movie>>
}