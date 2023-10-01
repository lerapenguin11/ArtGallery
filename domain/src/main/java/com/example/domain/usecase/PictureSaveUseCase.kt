package com.example.domain.usecase

import com.example.domain.entities.VolumePicture
import com.example.domain.repositories.PaintingsRepository

class PictureSaveUseCase(private val pictureRepository: PaintingsRepository) {

    suspend operator fun invoke(pic: VolumePicture) = pictureRepository.pictureSave(pic)
}