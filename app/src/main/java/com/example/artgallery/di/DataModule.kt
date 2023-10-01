package com.example.artgallery.di

import com.example.data.db.AppDatabase
import com.example.data.mappers.PictureEntityMapper
import com.example.data.repositories.*
import com.example.domain.repositories.PaintingsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<PaintingsDataSource> { PaintingsDataSourceImpl() }
    single<PictureLocalDataSource> { PictureLocalDataSourceImpl(get(), get()) }
    single<PaintingsRepository> { PaintingsRepositoryImpl(get(), get()) }
    single { AppDatabase.getDatabase(context = androidContext()).favoriteDao() }
    single { PictureEntityMapper() }
}