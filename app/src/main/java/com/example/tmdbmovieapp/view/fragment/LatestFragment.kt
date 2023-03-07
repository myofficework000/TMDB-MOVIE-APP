package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentLatestBinding
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import com.example.tmdbmovieapp.viewmodel.createFactory

class LatestFragment : Fragment() {
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
    ): View = DataBindingUtil.inflate<FragmentLatestBinding>(
        inflater, R.layout.fragment_latest, container, false
    ).apply {
        vm = viewModel
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.latestMovie.observe(viewLifecycleOwner) {
            println(it?.title)
            viewModel.notifyChange()
        }
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            println(it.title)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLatestMovies()
    }
}