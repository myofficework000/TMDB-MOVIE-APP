package com.example.tmdbmovieapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbmovieapp.databinding.TrendingItemBinding
import com.example.tmdbmovieapp.model.remote.Constant.POST_BASE
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingMovie
import com.squareup.picasso.Picasso

class TrendingRVAdapter(private val trendingItems: List<TrendingMovie>): RecyclerView.Adapter<TrendingRVAdapter.TrendingViewHolder>() {
    private lateinit var binding: TrendingItemBinding

    override fun getItemCount() = trendingItems.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingRVAdapter.TrendingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = TrendingItemBinding.inflate(layoutInflater, parent, false)
        return TrendingViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val trending = trendingItems[position]
        holder.bind(trending)
    }

    inner class TrendingViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(trending: TrendingMovie) {
            binding.apply {
                txtTitle.text = trending.title
                txtDate.text = trending.release_date
                txtVoteCount.text = trending.poster_path
                Picasso.get().load("$POST_BASE${trending.poster_path}").into(binding.imgMovie)
            }
        }
    }
}