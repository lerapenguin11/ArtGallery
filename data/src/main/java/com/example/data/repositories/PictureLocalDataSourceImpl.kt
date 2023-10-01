package com.example.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.data.db.FavoriteDao
import com.example.data.entities.PictureEntity
import com.example.data.mappers.PictureEntityMapper
import com.example.domain.entities.VolumePicture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class PictureLocalDataSourceImpl(
    private val favDao : FavoriteDao,
    private val pictureEntityMapper: PictureEntityMapper) : PictureLocalDataSource {

    val allFavorites: Flow<List<PictureEntity>> = favDao.getAllFavorites()

    override suspend fun getPicture(): Flow<List<VolumePicture>> {
        val savedBooksFlow = favDao.getAllFavorites()

        return savedBooksFlow.map { list ->
            list.map { element ->
                pictureEntityMapper.toVolume(element)
            }
        }
    }

    override suspend fun pictureSave(pic: VolumePicture) {
        withContext(Dispatchers.IO){
            favDao.insertFavorite(pictureEntityMapper.toPictureEntity(pic))
        }
    }

    override suspend fun pictureDelete(pic: VolumePicture) {
        withContext(Dispatchers.IO){
            favDao.deleteFavorite(pictureEntityMapper.toPictureEntity(pic))
        }
    }

    override suspend fun isFavorite(idPic: Int): Flow<Boolean> {
        return allFavorites.map { favorites ->
            favorites.any { it.idPic == it.idPic }
        }
    }

    override suspend fun deleteById(id: Int) {
        withContext(Dispatchers.IO){
            favDao.deleteById(id = id)
        }
    }
}