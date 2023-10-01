package com.example.artgallery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artgallery.entities.PictureWithStatus
import com.example.artgallery.mappers.PictureWithStatusMapper
import com.example.domain.entities.VolumePicture
import com.example.domain.usecase.*
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getPictureUseCase: GetPictureUseCase,
    private val pictureSaveUseCase: PictureSaveUseCase,
    private val pictureDeleteUseCase: PictureDeleteUseCase,
    private val mapper: PictureWithStatusMapper,
    private val isFavoriteUseCase: IsFavoriteUseCase,
    private val getDeleteByIdUseCase: GetDeleteByIdUseCase
) : ViewModel() {

    private val _favoriteList = MutableLiveData<List<VolumePicture>>()
    val favoriteList: LiveData<List<VolumePicture>> get() = _favoriteList

    val isLoading = MutableLiveData<Boolean>()

    fun insertFavorite(favorite: PictureWithStatus) = viewModelScope.launch{
        pictureSaveUseCase.invoke(mapper.fromPictureWithStatusToVolume(favorite))
    }

    fun deleteFavorite(favorite: VolumePicture) = viewModelScope.launch{
        pictureDeleteUseCase.invoke(favorite)
    }

    fun getAllFavorites() {
        viewModelScope.launch {
           getPictureUseCase.invoke()
                .collect{favorites ->
                    _favoriteList.value = favorites}
        }
    }

    fun isFavorite(picId : Int){
        viewModelScope.launch {
            isFavoriteUseCase.invoke(picId)
                .collect{
                    isLoading.value = it
                }
        }
    }

    fun deleteById(id : Int) = viewModelScope.launch {
        getDeleteByIdUseCase.invoke(id = id)
    }
}