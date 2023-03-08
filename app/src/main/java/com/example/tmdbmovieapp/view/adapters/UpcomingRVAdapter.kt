package com.example.tmdbmovieapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.UpcomingMovieItemBinding
import com.example.tmdbmovieapp.model.local.data.Movie
import com.example.tmdbmovieapp.model.remote.data.upcoming.UpcomingResponse

class UpcomingRVAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<UpcomingRVAdapter.UpcomingViewHolder>(){

    private lateinit var upcomingMovieItemBinding: UpcomingMovieItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: UpcomingMovieItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.upcoming_movie_item, parent, false)
        return UpcomingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    inner class UpcomingViewHolder(binding: UpcomingMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie:Movie) {
            upcomingMovieItemBinding.movie = movie
        }
    }

    override fun getItemCount() = movieList.size

}