package com.example.tmdbmovieapp.view.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.ActivityMainBinding
import com.example.tmdbmovieapp.view.adapters.UpcomingRVAdapter
import com.example.tmdbmovieapp.viewmodel.MovieListViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavController()
    }

    private fun setUpNavController() {
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.popularFragment,
                R.id.trendingFragment,
                R.id.upcomingFragment
            )
        )
        val navController = binding.fragmentContainerView.getFragment<NavHostFragment>().navController
        setupActionBarWithNavController(
             navController, appBarConfiguration
        )
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}