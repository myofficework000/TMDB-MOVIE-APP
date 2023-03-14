package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentPopularBinding
import com.example.tmdbmovieapp.databinding.MovieDetailFragmentBinding
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment(
    private val movieId: Int
): Fragment() {
    private val viewModel by viewModels<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<MovieDetailFragmentBinding>(
        inflater, R.layout.movie_detail_fragment, container, false
    ).apply {

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovieDetail(movieId)
    }
}