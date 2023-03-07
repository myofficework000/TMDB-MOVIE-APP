package com.example.tmdbmovieapp.model.local.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.Constant
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constant.TABLE_PRODUCTION_COUNTRY)
data class ProductionCountry(
    @PrimaryKey
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("name")
    val name: String
)