package com.example.artgallery.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.artgallery.R
import com.example.artgallery.databinding.FragmentFirstOnBoardingBinding
import com.example.artgallery.databinding.FragmentSecondBinding
import com.example.artgallery.presentation.ui.HomeFragment
import com.example.artgallery.presentation.ui.MainActivity
import com.example.artgallery.utilits.replaceFragmentMain

class SecondOnBoardingFragment : Fragment() {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.btNext.setOnClickListener { replaceFragmentMain(HomeFragment()) }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).hideBottomNavigationView()
    }
}