package com.example.domain.usecase

import com.example.domain.entities.VolumePicture
import com.example.domain.repositories.PaintingsRepository

class PictureDeleteUseCase(private val pictureRepository: PaintingsRepository) {

    suspend operator fun invoke(pic: VolumePicture) = pictureRepository.pictureDelete(pic)
}