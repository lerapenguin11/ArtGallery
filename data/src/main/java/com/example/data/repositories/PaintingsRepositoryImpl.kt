package com.example.data.repositories

import com.example.domain.entities.VolumePicture
import com.example.domain.repositories.PaintingsRepository
import kotlinx.coroutines.flow.Flow

class PaintingsRepositoryImpl(
    private val dataSource: PaintingsDataSource,
    private val localDataSource: PictureLocalDataSource) : PaintingsRepository{

    override suspend fun getPainting(picture: MutableList<VolumePicture>): MutableList<VolumePicture> {

        return dataSource.getPictureData(picture)
    }

    override suspend fun getPicture(): Flow<List<VolumePicture>> {
        return localDataSource.getPicture()
    }

    override suspend fun pictureSave(pic: VolumePicture) {
        localDataSource.pictureSave(pic)
    }

    override suspend fun pictureDelete(pic: VolumePicture) {
        localDataSource.pictureDelete(pic)
    }

    override suspend fun isFavorite(idPic: Int): Flow<Boolean> {
        return localDataSource.isFavorite(idPic = idPic)
    }

    override suspend fun deleteById(id: Int) {
        localDataSource.deleteById(id = id)
    }
}