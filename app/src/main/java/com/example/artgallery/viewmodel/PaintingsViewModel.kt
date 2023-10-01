package com.example.artgallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artgallery.Constants
import com.example.domain.entities.VolumePicture
import com.example.domain.usecase.GetPaintingsUseCase
import kotlinx.coroutines.launch

class PaintingsViewModel(
    private val getPaintingsUseCase : GetPaintingsUseCase) : ViewModel() {

    fun getResultPopular(): MutableList<VolumePicture> {
        var mutableData = mutableListOf<VolumePicture>()
        viewModelScope.launch{
            mutableData = getPaintingsUseCase.invoke(Constants.getPopularData())
        }

        return mutableData
    }

    fun getResultNewest(): MutableList<VolumePicture> {
        var mutableData = mutableListOf<VolumePicture>()
        viewModelScope.launch{
            mutableData = getPaintingsUseCase.invoke(Constants.getNewestData())
        }

        return mutableData
    }

    fun getResultAll(): MutableList<VolumePicture> {
        var mutableData = mutableListOf<VolumePicture>()
        viewModelScope.launch{
            mutableData = getPaintingsUseCase.invoke(Constants.getAllData())
        }

        return mutableData
    }
}