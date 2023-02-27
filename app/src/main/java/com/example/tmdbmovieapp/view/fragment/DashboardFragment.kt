package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.tmdbmovieapp.databinding.FragmentDashboardBinding
import com.example.tmdbmovieapp.view.adapters.DashboardViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDashboardBinding.inflate(inflater,container, false).apply{
        dashboardFragment = this@DashboardFragment
    }.root

    companion object {
        @JvmStatic
        @BindingAdapter("setupWithTab", "fragment")
        fun setViewPagerAdapter(viewPager: ViewPager2, tabLayout: TabLayout, fragment: Fragment) {
            viewPager.adapter = DashboardViewPagerAdapter(fragment)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = DashboardViewPagerAdapter.pageNames[position]
            }.attach()
        }
    }
}