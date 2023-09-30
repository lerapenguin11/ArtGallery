package com.example.artgallery.di

import com.example.domain.usecase.GetPaintingsUseCase
import org.koin.dsl.module

val domainModule = module {
    //single<PaintingsRepository> { PaintingsRepositoryImpl(get()) }

    factory<GetPaintingsUseCase> { GetPaintingsUseCase(
        pictureRepository = get()
    ) }
}