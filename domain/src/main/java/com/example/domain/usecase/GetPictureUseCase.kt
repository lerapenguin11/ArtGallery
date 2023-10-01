package com.example.domain.usecase

import com.example.domain.repositories.PaintingsRepository

class GetPictureUseCase(private val pictureRepository: PaintingsRepository) {

    suspend operator fun invoke() = pictureRepository.getPicture()
}