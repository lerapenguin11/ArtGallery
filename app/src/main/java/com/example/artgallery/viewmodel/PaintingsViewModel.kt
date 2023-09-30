package com.example.artgallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artgallery.Constants
import com.example.domain.entities.VolumePicture
import com.example.domain.usecase.GetPaintingsUseCase
import kotlinx.coroutines.launch

class PaintingsViewModel(
    private val getPaintingsUseCase : GetPaintingsUseCase) : ViewModel() {

    fun getResultMeditationVeryGood(): MutableList<VolumePicture> {
        var mutableData = mutableListOf<VolumePicture>()
        viewModelScope.launch{
            mutableData = getPaintingsUseCase.invoke(Constants.getMeditationVeryGoodData())
        }

        return mutableData
    }
}