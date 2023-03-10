package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentTrendingBinding
import com.example.tmdbmovieapp.model.local.AppDatabase
import com.example.tmdbmovieapp.model.remote.ApiService
import com.example.tmdbmovieapp.model.remote.RetrofitBuilder
import com.example.tmdbmovieapp.model.remote.data.trending.TrendingResponse
import com.example.tmdbmovieapp.model.repository.LocalRepository
import com.example.tmdbmovieapp.model.repository.RemoteRepository
import com.example.tmdbmovieapp.model.repository.Repository
import com.example.tmdbmovieapp.view.adapters.TrendingRVAdapter
import com.example.tmdbmovieapp.viewmodel.TrendingViewModel
import com.example.tmdbmovieapp.viewmodel.createFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TrendingFragment : Fragment() {
    private lateinit var binding: FragmentTrendingBinding
    private lateinit var viewModel: TrendingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setUpObserver()
    }

    private fun initViewModel() {
        val remoteRepository = RemoteRepository(RetrofitBuilder.getRetrofit().create(ApiService::class.java))
        val localRepository = LocalRepository(AppDatabase.getInstance(requireContext().applicationContext))
        val repository = Repository(AppDatabase.getInstance(requireContext().applicationContext), localRepository, remoteRepository)
        val factory = TrendingViewModel(requireActivity().application, repository).createFactory()
        viewModel = ViewModelProvider(requireActivity(), factory)[TrendingViewModel::class.java]
    }

    private fun setUpObserver() {
        viewModel.trendingMovies.observe(requireActivity()) {
            binding.rvTrending.layoutManager = LinearLayoutManager(requireContext())
            binding.rvTrending.adapter = TrendingRVAdapter(it)
        }
    }
}