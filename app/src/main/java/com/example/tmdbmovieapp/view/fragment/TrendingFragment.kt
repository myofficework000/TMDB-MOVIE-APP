package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentTrendingBinding
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.local.MoviesDao
import com.example.tmdbmovieapp.model.remote.data.upcoming.MoviesListResponse
import com.example.tmdbmovieapp.view.adapters.UpcomingRVAdapter
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import com.example.tmdbmovieapp.viewmodel.createFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingFragment : Fragment() {
    private lateinit var binding: FragmentTrendingBinding
    private lateinit var db: AppDatabase
    private lateinit var movieDao: MoviesDao
    private lateinit var rvAdapter: UpcomingRVAdapter
    private lateinit var movieList: List<MoviesListResponse>

    private val viewModel by viewModels<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentTrendingBinding>(
        inflater, R.layout.fragment_trending, container, false
    ).apply {
        binding = this
        binding.rvUpMovies.layoutManager = LinearLayoutManager(context)

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.topRatedMovies.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            binding.rvUpMovies.adapter = UpcomingRVAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTrendingMovies()
    }
}