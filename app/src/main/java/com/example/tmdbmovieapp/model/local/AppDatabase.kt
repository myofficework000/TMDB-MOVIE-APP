package com.example.tmdbmovieapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbmovieapp.model.local.data.*
import com.example.tmdbmovieapp.model.remote.data.latestmovie.LatestMovieResponse
import com.example.tmdbmovieapp.model.remote.data.upcoming.UpcomingResponse

@Database(entities = [
    Movie::class,
    MovieDetail::class,
    MovieGenre::class,
    ProductionCompany::class,
    ProductionCountry::class,
    SpokenLanguage::class
                     ], version = 1, exportSchema = false)

@androidx.room.TypeConverters(TypeConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
    abstract fun getUpComingMovieDao(): UpcomingMoiveDao

    abstract fun getTrendingMovieDao(): TrendingMovieDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "movieDB"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE as AppDatabase
        }
    }
}