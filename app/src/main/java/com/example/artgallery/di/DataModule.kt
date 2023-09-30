package com.example.artgallery.di

import com.example.data.repositories.PaintingsDataSource
import com.example.data.repositories.PaintingsDataSourceImpl
import com.example.data.repositories.PaintingsRepositoryImpl
import com.example.domain.repositories.PaintingsRepository
import org.koin.dsl.module

val dataModule = module {
    single<PaintingsDataSource> { PaintingsDataSourceImpl() }
    single<PaintingsRepository> { PaintingsRepositoryImpl(get()) }
}