package com.example.artgallery.presentation.ui

import android.R
import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.artgallery.databinding.FragmentSaveBinding
import com.example.artgallery.entities.FavoriteStatus
import com.example.artgallery.entities.PictureWithStatus
import com.example.artgallery.presentation.ui.adapter.FavoriteAdapter
import com.example.artgallery.presentation.ui.adapter.listener.FavoriteListener
import com.example.artgallery.viewmodel.FavoriteViewModel
import com.example.domain.entities.VolumePicture
import org.koin.androidx.viewmodel.ext.android.viewModel

class SaveFragment : Fragment(), FavoriteListener {
    private var _binding : FragmentSaveBinding? = null
    private val binding get() = _binding!!
    private val adapter = FavoriteAdapter(this)
    private val favoriteViewModel by viewModel<FavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSaveBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        favoriteViewModel.getAllFavorites()
        observeData()
        favoriteViewModel.favoriteList.observe(viewLifecycleOwner, Observer {
            println(it)
        })
    }

    private fun observeData() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvSave.layoutManager = layoutManager
        binding.rvSave.adapter = adapter

        favoriteViewModel.favoriteList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.setItem(it)
        })
    }

    override fun getFavorite(pic: VolumePicture) {
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

        btSave.setOnClickListener {

            favoriteViewModel.favoriteList.observe(viewLifecycleOwner, Observer {
                for (i in it){
                    if (i.id == pic.id){
                        favoriteViewModel.deleteById(id = pic.id)
                        adapter.setItem(it)
                        dialog.cancel()
                    }
                }
            })
        }

        btArrow.setOnClickListener { dialog.cancel() }

        dialog.show()
    }
}