package com.example.artgallery.di

import com.example.artgallery.viewmodel.PaintingsViewModel
import com.example.domain.usecase.GetPaintingsUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PaintingsViewModel> {
        PaintingsViewModel(
            getPaintingsUseCase = GetPaintingsUseCase(get())
        )
    }
}