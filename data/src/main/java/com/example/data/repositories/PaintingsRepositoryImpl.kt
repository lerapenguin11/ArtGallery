package com.example.data.repositories

import com.example.domain.entities.VolumePicture
import com.example.domain.repositories.PaintingsRepository

class PaintingsRepositoryImpl(
    private val dataSource: PaintingsDataSource) : PaintingsRepository{

    override suspend fun getPainting(picture: MutableList<VolumePicture>): MutableList<VolumePicture> {

        return dataSource.getPictureData(picture)
    }
}