package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentUpcomingBinding
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.local.MoviesDao
import com.example.tmdbmovieapp.model.remote.data.upcoming.MoviesListResponse
import com.example.tmdbmovieapp.view.adapters.UpcomingRVAdapter
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import com.example.tmdbmovieapp.viewmodel.createFactory

class UpcomingFragment : Fragment() {
    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var db: AppDatabase
    private lateinit var movieDao: MoviesDao
    private lateinit var rvAdapter: UpcomingRVAdapter
    private lateinit var movieList: List<MoviesListResponse>

    private val viewModel by lazy {
        requireActivity().run {
            ViewModelProvider(
                requireActivity(), MovieListViewModel(application).createFactory()
            )[MovieListViewModel::class.java]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentUpcomingBinding>(
        inflater, R.layout.fragment_upcoming, container, false
    ).apply {
        binding = this
        binding.rvUpMovies.layoutManager = LinearLayoutManager(context)

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.upComingMovies.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            binding.rvUpMovies.adapter = UpcomingRVAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getUpcomingMovies()
    }

}