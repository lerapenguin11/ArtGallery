package com.example.domain.usecase

import com.example.domain.repositories.PaintingsRepository

class GetDeleteByIdUseCase(private val pictureRepository: PaintingsRepository) {

    suspend operator fun invoke(id : Int) = pictureRepository.deleteById(id = id)
}