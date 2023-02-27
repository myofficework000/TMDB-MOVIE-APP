package com.example.tmdbmovieapp.model.local

import androidx.room.TypeConverter
import com.example.tmdbmovieapp.model.remote.data.latestmovie.MovieGenres
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverters {
    @TypeConverter fun fromMovieGenresList(value: List<MovieGenres>) = Gson().toJson(value)
    @TypeConverter fun toMovieGenresList(value: String) = Gson().fromJsonList<MovieGenres>(value)

    inline fun <reified T> Gson.fromJsonList(value: String) =
        fromJson<List<T>>(value, object: TypeToken<List<T>>() {}.type).toList()
}