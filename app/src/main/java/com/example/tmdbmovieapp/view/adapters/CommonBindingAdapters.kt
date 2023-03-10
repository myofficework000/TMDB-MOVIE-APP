package com.example.tmdbmovieapp.view.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.model.remote.Constant.BASE_IMAGE_URL
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
    }
}