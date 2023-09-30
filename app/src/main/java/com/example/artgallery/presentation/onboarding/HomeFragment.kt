package com.example.artgallery.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.artgallery.R
import com.example.artgallery.databinding.FragmentHomeBinding
import com.example.artgallery.presentation.MainActivity
import com.example.artgallery.presentation.adapter.PaintingsAdapter
import com.example.artgallery.viewmodel.PaintingsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<PaintingsViewModel>()
    private val adapter = PaintingsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvHome.layoutManager = layoutManager
        binding.rvHome.adapter = adapter

        adapter.setItem(viewModel.getResultMeditationVeryGood())

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showBottomNavigationView()
    }
}