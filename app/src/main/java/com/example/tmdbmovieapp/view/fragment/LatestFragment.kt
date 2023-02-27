package com.example.tmdbmovieapp.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.FragmentLatestBinding

class LatestFragment : Fragment() {
    private lateinit var binding: FragmentLatestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLatestBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root
}