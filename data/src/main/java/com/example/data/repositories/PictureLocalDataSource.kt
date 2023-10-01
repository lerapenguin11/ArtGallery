package com.example.data.repositories

import com.example.domain.entities.VolumePicture
import kotlinx.coroutines.flow.Flow

interface PictureLocalDataSource {

    suspend fun getPicture(): Flow<List<VolumePicture>>

    suspend fun pictureSave(pic: VolumePicture)

    suspend fun pictureDelete(pic: VolumePicture)

    suspend fun isFavorite(idPic: Int): Flow<Boolean>

    suspend fun deleteById(id : Int)
}