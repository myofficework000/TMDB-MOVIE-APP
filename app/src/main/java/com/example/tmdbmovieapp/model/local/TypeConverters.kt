package com.example.tmdbmovieapp.model.local

import androidx.room.TypeConverter
import com.example.tmdbmovieapp.model.local.data.MovieGenre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverters {
    @TypeConverter fun fromMovieGenresList(value: List<MovieGenre>) = Gson().toJson(value)
    @TypeConverter fun toMovieGenresList(value: String) = Gson().fromJsonList<MovieGenre>(value)

    @TypeConverter fun fromIntList(value: List<Int>) = Gson().toJson(value)
    @TypeConverter fun toIntList(value: String) = Gson().fromJsonList<Int>(value)
    @TypeConverter fun fromStringList(value: List<String>) = Gson().toJson(value)
    @TypeConverter fun toStringList(value: String) = Gson().fromJsonList<String>(value)

    inline fun <reified T> Gson.fromJsonList(value: String) =
        fromJson<List<T>>(value, object: TypeToken<List<T>>() {}.type).toList()
}