package com.example.data.repositories

import com.example.domain.entities.VolumePicture

interface PaintingsDataSource {

    suspend fun getPictureData(picture: MutableList<VolumePicture>) : MutableList<VolumePicture>
}