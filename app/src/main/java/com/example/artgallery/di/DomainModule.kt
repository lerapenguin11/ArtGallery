package com.example.artgallery.di

import com.example.domain.usecase.GetPaintingsUseCase
import com.example.domain.usecase.GetPictureUseCase
import com.example.domain.usecase.PictureDeleteUseCase
import com.example.domain.usecase.PictureSaveUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetPaintingsUseCase> { GetPaintingsUseCase(
        pictureRepository = get()
    ) }

    factory<GetPictureUseCase> {  GetPictureUseCase(
        pictureRepository = get()
    )}

    factory<PictureDeleteUseCase> { PictureDeleteUseCase(
        pictureRepository = get()
    ) }

    factory<PictureSaveUseCase> { PictureSaveUseCase(
        pictureRepository = get()
    ) }
}