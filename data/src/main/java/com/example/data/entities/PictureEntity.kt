package com.example.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class PictureEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val idPic : Int,
    val title : Int,
    val description : Int,
    val icon : String,
    val dateCity : Int
)
