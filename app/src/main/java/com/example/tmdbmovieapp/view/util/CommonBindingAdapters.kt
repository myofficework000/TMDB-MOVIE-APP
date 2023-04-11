package com.example.tmdbmovieapp.view.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.model.remote.Constant.BASE_IMAGE_URL
import com.example.tmdbmovieapp.view.adapters.DashboardViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.squareup.picasso.Picasso

class CommonBindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("remoteSourceImage")
        fun loadImageFromServer(imageView: ImageView, url: String?) = with(url) {
            val path = "$BASE_IMAGE_URL$this"
            Picasso
                .get()
                .load(path)
                .error(R.drawable.baseline_error_24)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }

        /*@JvmStatic
        @BindingAdapter("setupWithTab", "fragment")
        fun setViewPagerAdapter(viewPager: ViewPager2, tabLayout: TabLayout, fragment: Fragment) {
            viewPager.adapter = DashboardViewPagerAdapter(fragment)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = DashboardViewPagerAdapter.pageNames[position]
            }.attach()
        }*/
    }
}