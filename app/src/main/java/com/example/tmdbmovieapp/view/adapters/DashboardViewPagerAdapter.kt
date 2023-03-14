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
        0 -> UpcomingFragment()
        1 -> TrendingFragment()
        2 -> PopularFragment()
        else -> UpcomingFragment()
    }

    companion object {
        val pageNames = listOf(
            "Uncoming",
            "Trending",
            "Popular"
        )
    }
}