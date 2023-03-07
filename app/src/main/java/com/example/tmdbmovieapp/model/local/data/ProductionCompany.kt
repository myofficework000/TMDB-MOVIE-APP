package com.example.tmdbmovieapp.model.local.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdbmovieapp.model.remote.Constant
import com.google.gson.annotations.SerializedName

@Entity(tableName = Constant.TABLE_PRODUCTION_COMPANY)
data class ProductionCompany(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)