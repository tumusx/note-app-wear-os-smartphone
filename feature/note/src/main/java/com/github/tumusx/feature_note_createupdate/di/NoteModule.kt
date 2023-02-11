package com.github.tumusx.feature_note_createupdate.di

import com.example.database.database.AppDataBase
import com.github.tumusx.feature_note_createupdate.data.repository.NoteRepositoryImpl
import com.github.tumusx.feature_note_createupdate.domain.repository.INoteRepository
import com.github.tumusx.feature_note_createupdate.domain.useCase.INoteUseCase
import com.github.tumusx.feature_note_createupdate.domain.useCase.NoteUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {
    @Provides
    @Singleton
    fun providerRepositoryInject(appDataBase: AppDataBase): INoteRepository =
        NoteRepositoryImpl(appDataBase)

    @Provides
    @Singleton
    fun providerUseCaseInject(noteRepository: INoteRepository): INoteUseCase =
        NoteUseCaseImpl(noteRepository)
}