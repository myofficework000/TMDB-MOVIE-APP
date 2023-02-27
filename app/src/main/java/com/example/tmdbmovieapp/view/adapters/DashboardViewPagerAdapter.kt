package com.example.tmdbmovieapp.view.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tmdbmovieapp.view.fragment.LatestFragment
import com.example.tmdbmovieapp.view.fragment.PopularFragment
import com.example.tmdbmovieapp.view.fragment.TrendingFragment
import com.example.tmdbmovieapp.view.fragment.UpcomingFragment

class DashboardViewPagerAdapter(
    fragment: Fragment
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = pageNames.size

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> LatestFragment()
        1 -> UpcomingFragment()
        2 -> TrendingFragment()
        3 -> PopularFragment()
        else -> LatestFragment()
    }

    companion object {
        val pageNames = listOf(
            "Latest Movies",
            "Uncoming Movies",
            "Trending Movies",
            "Popular Movies"
        )
    }
}