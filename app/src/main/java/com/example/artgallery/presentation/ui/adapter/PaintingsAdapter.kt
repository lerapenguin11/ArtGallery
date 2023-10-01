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
import com.example.artgallery.presentation.ui.adapter.listener.PaintingsListener
import com.example.domain.entities.VolumePicture

class PaintingsAdapter(private val listener : PaintingsListener) : RecyclerView.Adapter<PaintingsAdapter.PaintingsViewHolder>(){

    private val pictureList = mutableListOf<VolumePicture>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaintingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_art, parent, false)

        return PaintingsViewHolder(view)
    }

    override fun getItemCount(): Int = pictureList.size

    override fun onBindViewHolder(holder: PaintingsViewHolder, position: Int) {
        val picture = pictureList[position]
        holder.title.setText(picture.volumeInfo.title)
        holder.dateCity.setText(picture.volumeInfo.dateCity)
        Glide.with(holder.itemView)
            .load(picture.volumeInfo.icon)
            .into(holder.icon)

        holder.itemView.setOnClickListener {
            listener.getPaintings(picture)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(picList : List<VolumePicture>){
        pictureList.clear()
        pictureList.addAll(picList)
        notifyDataSetChanged()
    }

    class PaintingsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.tv_name_picture)
        val icon : ImageView = view.findViewById(R.id.ic_picture)
        val dateCity : TextView = view.findViewById(R.id.tv_year_city)
    }
}