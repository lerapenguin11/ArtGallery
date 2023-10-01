package com.example.domain.usecase

import com.example.domain.repositories.PaintingsRepository

class IsFavoriteUseCase(private val pictureRepository: PaintingsRepository) {

    suspend operator fun invoke(picId: Int) = pictureRepository.isFavorite(picId)
}