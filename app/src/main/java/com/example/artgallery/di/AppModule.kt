package com.example.artgallery.di

import com.example.artgallery.mappers.PictureWithStatusMapper
import com.example.artgallery.viewmodel.FavoriteViewModel
import com.example.artgallery.viewmodel.PaintingsViewModel
import com.example.domain.usecase.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PaintingsViewModel> {
        PaintingsViewModel(
            getPaintingsUseCase = GetPaintingsUseCase(get())
        )
    }

    viewModel<FavoriteViewModel>{
        FavoriteViewModel(
            getPictureUseCase = GetPictureUseCase(get()),
            pictureDeleteUseCase = PictureDeleteUseCase(get()),
            pictureSaveUseCase = PictureSaveUseCase(get()),
            mapper = PictureWithStatusMapper(),
            isFavoriteUseCase = IsFavoriteUseCase(get()),
            getDeleteByIdUseCase = GetDeleteByIdUseCase(get())
        )
    }
}