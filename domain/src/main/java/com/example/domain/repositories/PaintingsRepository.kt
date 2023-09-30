package com.example.domain.repositories

import com.example.domain.entities.VolumePicture

interface PaintingsRepository {

    suspend fun getPainting(picture : MutableList<VolumePicture>) : MutableList<VolumePicture>
}