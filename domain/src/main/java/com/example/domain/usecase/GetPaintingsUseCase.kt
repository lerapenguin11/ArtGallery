package com.example.domain.usecase

import com.example.domain.entities.VolumePicture
import com.example.domain.repositories.PaintingsRepository

class GetPaintingsUseCase(private val pictureRepository: PaintingsRepository) {

    suspend operator fun invoke(picture: MutableList<VolumePicture>) = pictureRepository.getPainting(picture)
}