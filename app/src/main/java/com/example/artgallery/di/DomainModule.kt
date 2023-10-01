package com.example.artgallery.di

import com.example.domain.usecase.*
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

    factory<GetDeleteByIdUseCase> { GetDeleteByIdUseCase(
        pictureRepository = get()
    ) }
}