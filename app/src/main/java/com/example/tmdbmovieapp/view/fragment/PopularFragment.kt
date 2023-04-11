package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentPopularBinding
import com.example.tmdbmovieapp.databinding.FragmentTrendingBinding
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.local.MoviesDao
import com.example.tmdbmovieapp.model.remote.data.upcoming.MoviesListResponse
import com.example.tmdbmovieapp.view.adapters.UpcomingRVAdapter
import com.example.tmdbmovieapp.view.util.UiUtils
import com.example.tmdbmovieapp.view.util.UiUtils.replaceFragment
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    private lateinit var db: AppDatabase
    private lateinit var movieDao: MoviesDao
    private lateinit var rvAdapter: UpcomingRVAdapter
    private lateinit var movieList: List<MoviesListResponse>

    private val viewModel by viewModels<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentPopularBinding>(
        inflater, R.layout.fragment_popular, container, false
    ).apply {
        binding = this
        binding.rvPopularMovies.layoutManager = LinearLayoutManager(context)

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.popularMovieData.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            binding.rvPopularMovies.adapter = UpcomingRVAdapter(it) { movie ->
                findNavController().navigate(R.id.action_popularFragment_to_detailFragment)
                /*(requireActivity() as AppCompatActivity).replaceFragment(
                    R.id.dashboardFragment, DetailFragment(movie.id)
                )*/
            }
        }

        viewModel.getPopularMovies()
    }
}