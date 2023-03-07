package com.example.tmdbmovieapp.model.local.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.Constant
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constant.TABLE_SPOKEN_LANGUAGE)
data class SpokenLanguage(
    @PrimaryKey
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)