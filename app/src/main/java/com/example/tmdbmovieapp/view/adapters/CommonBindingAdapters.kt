package com.example.tmdbmovieapp.view.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.tmdbmovieapp.R
import com.squareup.picasso.Picasso

class CommonBindingAdapters {
    companion object {

        @JvmStatic
        @BindingAdapter("remoteSourceImage")
        fun loadImageFromServer(imageView: ImageView, url: String?) = with(url) {
            if (!isNullOrEmpty() && contains("https://")) {
                Picasso
                    .get()
                    .load(this)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView)
            }
        }
    }
}