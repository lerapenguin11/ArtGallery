package com.example.artgallery.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.artgallery.databinding.FragmentSaveBinding
import com.example.artgallery.presentation.ui.adapter.FavoriteAdapter
import com.example.artgallery.viewmodel.FavoriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SaveFragment : Fragment() {
    private var _binding : FragmentSaveBinding? = null
    private val binding get() = _binding!!
    private val adapter = FavoriteAdapter()
    private val favoriteViewModel by viewModel<FavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSaveBinding.inflate(inflater, container, false)
        favoriteViewModel.getAllFavorites()
        observeData()

        return binding.root
    }

    private fun observeData() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvSave.layoutManager = layoutManager
        binding.rvSave.adapter = adapter

        favoriteViewModel.favoriteList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.setItem(it)
        })
    }
}