package com.example.data.db

import androidx.room.*
import com.example.data.entities.PictureEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): Flow<List<PictureEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favorite: PictureEntity)

    @Delete
    fun deleteFavorite(favorite: PictureEntity)
}