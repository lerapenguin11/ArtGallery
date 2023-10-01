package com.example.artgallery.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artgallery.R
import com.example.domain.entities.VolumePicture

class FavoriteAdapter() : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){

    private val favPictureList = mutableListOf<VolumePicture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_art, parent, false)

        return FavoriteViewHolder(view)
    }

    override fun getItemCount(): Int = favPictureList.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val picture = favPictureList[position]
        holder.title.setText(picture.volumeInfo.title)
        holder.dateCity.setText(picture.volumeInfo.dateCity)
        Glide.with(holder.itemView)
            .load(picture.volumeInfo.icon)
            .into(holder.icon)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(favPicList : List<VolumePicture>){
        favPictureList.clear()
        favPictureList.addAll(favPicList)
        notifyDataSetChanged()
    }

    class FavoriteViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.tv_name_picture)
        val icon : ImageView = view.findViewById(R.id.ic_picture)
        val dateCity : TextView = view.findViewById(R.id.tv_year_city)
    }
}