package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentLatestBinding
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import com.example.tmdbmovieapp.viewmodel.createFactory

class LatestFragment : Fragment() {
    private val viewModel by lazy {
        requireActivity().run {
            ViewModelProvider(
                this, MovieListViewModel(application).createFactory()
            )[MovieListViewModel::class.java]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentLatestBinding>(
        inflater, R.layout.fragment_latest, container, false
    ).apply {
        vm = viewModel
    }.root

    override fun onResume() {
        super.onResume()
        viewModel.getLatestMovies()
    }
}