package com.example.tmdbmovieapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.model.remote.data.Movie

interface IRepository {

    fun getLatestMovie(): LiveData<List<Movie>>

  /*  fun updateLatestNews()

    fun searchNews(
        keywords: String,
        start_date: String,
        end_date: String,
        category: String? = null,
        country: String? = null,
        language: String? = null
    )
*/
    val isProcessing: MutableLiveData<Boolean>
    val searchedNews: MutableLiveData<List<Movie>>
}