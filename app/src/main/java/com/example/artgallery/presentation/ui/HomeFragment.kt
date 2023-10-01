package com.example.artgallery.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.artgallery.databinding.FragmentHomeBinding
import com.example.artgallery.entities.FavoriteStatus
import com.example.artgallery.entities.PictureWithStatus
import com.example.artgallery.presentation.ui.adapter.PaintingsAdapter
import com.example.artgallery.presentation.ui.adapter.listener.PaintingsListener
import com.example.artgallery.viewmodel.FavoriteViewModel
import com.example.artgallery.viewmodel.PaintingsViewModel
import com.example.domain.entities.VolumePicture
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), PaintingsListener {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val paintingsViewModel by viewModel<PaintingsViewModel>()
    private val favoriteViewModel by viewModel<FavoriteViewModel>()
    private val adapter = PaintingsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        observeData()

        return binding.root
    }

    private fun observeData() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvHome.layoutManager = layoutManager
        binding.rvHome.adapter = adapter
        adapter.setItem(paintingsViewModel.getResultMeditationVeryGood())
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showBottomNavigationView()
    }

    override fun getPaintings(pic: VolumePicture) {
        val picture = PictureWithStatus(id = pic.id, title = pic.volumeInfo.title,
            description = pic.volumeInfo.description, icon = pic.volumeInfo.icon,
            dateCity = pic.volumeInfo.dateCity, status = FavoriteStatus.FAVORITE)
        favoriteViewModel.insertFavorite(picture)
    }

}