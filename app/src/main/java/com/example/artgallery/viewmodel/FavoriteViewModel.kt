package com.example.artgallery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artgallery.entities.PictureWithStatus
import com.example.artgallery.mappers.PictureWithStatusMapper
import com.example.domain.entities.VolumePicture
import com.example.domain.usecase.GetPictureUseCase
import com.example.domain.usecase.PictureDeleteUseCase
import com.example.domain.usecase.PictureSaveUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getPictureUseCase: GetPictureUseCase,
    private val pictureSaveUseCase: PictureSaveUseCase,
    private val pictureDeleteUseCase: PictureDeleteUseCase,
    private val mapper: PictureWithStatusMapper
) : ViewModel() {

    var list =  listOf<VolumePicture>()

    private val _favoriteList = MutableLiveData<List<VolumePicture>>()
    val favoriteList: LiveData<List<VolumePicture>> get() = _favoriteList

    fun insertFavorite(favorite: PictureWithStatus) = viewModelScope.launch{
        pictureSaveUseCase.invoke(mapper.fromPictureWithStatusToVolume(favorite))
    }

    fun deleteFavorite(favorite: PictureWithStatus) = viewModelScope.launch{
        pictureDeleteUseCase.invoke(mapper.fromPictureWithStatusToVolume(favorite))
    }

    fun getAllFavorites() {
        viewModelScope.launch {
           getPictureUseCase.invoke()
                .collect{favorites ->
                    _favoriteList.value = favorites}
        }
    }
}