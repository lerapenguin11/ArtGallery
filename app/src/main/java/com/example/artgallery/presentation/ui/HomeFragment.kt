package com.example.artgallery.presentation.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.artgallery.databinding.FragmentHomeBinding
import android.R
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
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

        val dialog = Dialog(requireContext(), R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(com.example.artgallery.R.layout.full_screen_details)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        dialog.window?.statusBarColor = ContextCompat.getColor(requireContext(), android.R.color.transparent)

        val icon : ImageView = dialog.findViewById(com.example.artgallery.R.id.ic_picture_details)
        val title : TextView = dialog.findViewById(com.example.artgallery.R.id.tv_name_picture_details)
        val description : TextView = dialog.findViewById(com.example.artgallery.R.id.tv_description_details)
        val btArrow : ImageView = dialog.findViewById(com.example.artgallery.R.id.ic_arrow)
        val btSave : ImageView = dialog.findViewById(com.example.artgallery.R.id.ic_save)


        title.setText(pic.volumeInfo.title)
        description.setText(pic.volumeInfo.description)
        Glide.with(requireContext())
            .load(pic.volumeInfo.icon)
            .into(icon)

        favoriteViewModel.getAllFavorites()
        favoriteViewModel.isFavorite(picId = pic.id)
        btSave.setOnClickListener {
            if (favoriteViewModel.isLoading.value!! == false){
                val picture = PictureWithStatus(
                    id = pic.id, title = pic.volumeInfo.title,
                    description = pic.volumeInfo.description, icon = pic.volumeInfo.icon,
                    dateCity = pic.volumeInfo.dateCity, status = FavoriteStatus.FAVORITE
                )
                favoriteViewModel.insertFavorite(picture)
                favoriteViewModel.getAllFavorites()
                btSave.setImageResource(com.example.artgallery.R.drawable.ic_save_click)
            }
        }

        btArrow.setOnClickListener { dialog.cancel() }

        dialog.show()
    }

}