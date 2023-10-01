package com.example.artgallery.entities

data class PictureWithStatus(
    val id : Int,
    val title : Int,
    val description : Int,
    val icon : String,
    val dateCity : Int,
    val status: FavoriteStatus
)