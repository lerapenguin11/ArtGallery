package com.example.domain.repositories

import com.example.domain.entities.VolumePicture
import kotlinx.coroutines.flow.Flow

interface PaintingsRepository {

    suspend fun getPainting(picture : MutableList<VolumePicture>) : MutableList<VolumePicture>

    suspend fun getPicture(): Flow<List<VolumePicture>>

    suspend fun pictureSave(pic: VolumePicture)

    suspend fun pictureDelete(pic: VolumePicture)

    suspend fun isFavorite(idPic: Int): Flow<Boolean>

    suspend fun deleteById(id : Int)
}