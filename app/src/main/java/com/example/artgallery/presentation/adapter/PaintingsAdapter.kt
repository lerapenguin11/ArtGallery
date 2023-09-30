package com.example.artgallery.presentation.adapter

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

class PaintingsAdapter() : RecyclerView.Adapter<PaintingsAdapter.PaintingsViewHolder>(){

    private val meditationList = mutableListOf<VolumePicture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaintingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_art, parent, false)

        return PaintingsViewHolder(view)
    }

    override fun getItemCount(): Int = meditationList.size

    override fun onBindViewHolder(holder: PaintingsViewHolder, position: Int) {
        val meditation = meditationList[position]
        holder.title.setText(meditation.volumeInfo.title)
        holder.dateCity.setText(meditation.volumeInfo.dateCity)
        Glide.with(holder.itemView)
            .load(meditation.volumeInfo.icon)
            .into(holder.icon)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(medList : List<VolumePicture>){
        meditationList.clear()
        meditationList.addAll(medList)
        notifyDataSetChanged()
    }

    class PaintingsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.tv_name_picture)
        val icon : ImageView = view.findViewById(R.id.ic_picture)
        val dateCity : TextView = view.findViewById(R.id.tv_year_city)
    }
}