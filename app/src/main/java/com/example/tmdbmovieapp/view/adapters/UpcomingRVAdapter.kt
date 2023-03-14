package com.example.tmdbmovieapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.UpcomingMovieItemBinding
import com.example.tmdbmovieapp.model.local.data.Movie

class UpcomingRVAdapter(
    private val movieList: List<Movie>,
    private val onItemClick: (Movie)->Unit = {}
): RecyclerView.Adapter<UpcomingRVAdapter.UpcomingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val upcomingMovieItemBinding = DataBindingUtil
            .inflate<UpcomingMovieItemBinding>(
                layoutInflater, R.layout.upcoming_movie_item, parent, false)
        return UpcomingViewHolder(upcomingMovieItemBinding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) =
        holder.bind(movieList[position])

    inner class UpcomingViewHolder(private val binding: UpcomingMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.root.setOnClickListener { onItemClick(movie) }
        }
    }

    override fun getItemCount() = movieList.size

}