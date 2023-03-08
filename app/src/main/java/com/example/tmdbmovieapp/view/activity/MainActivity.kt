package com.example.tmdbmovieapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.ActivityMainBinding
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var MovieListViewModel : MovieListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}