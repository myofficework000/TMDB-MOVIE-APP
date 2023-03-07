package com.example.tmdbmovieapp.model.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.Constant

@Entity(tableName = Constant.TABLE_MOVIE_GENRE)
data class MovieGenre(
    @PrimaryKey
    val id: Int,
    val name: String
)
