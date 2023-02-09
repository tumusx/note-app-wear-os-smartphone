package com.github.tumusx.note_list.di

import android.app.Application
import androidx.room.Room
import com.example.database.database.AppDataBase
import com.github.tumusx.note_list.data.repository.ListNoteRepositoryImpl
import com.github.tumusx.note_list.domain.repository.IListNoteRepository
import com.github.tumusx.note_list.domain.useCase.IListNoteUseCase
import com.github.tumusx.note_list.domain.useCase.ListNoteUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Module
@InstallIn(SingletonComponent::class)
object NoteListModule {

    @Provides
    fun builderDatabase(application: Application): AppDataBase {
        return Room.databaseBuilder(application, AppDataBase::class.java, "note.db").build()
    }

/*    @IoDispatcher
    @Provides
    fun coroutineDispatcher() = Dispatchers.IO*/

    @Provides
    fun builderRepository(appDataBase: AppDataBase): IListNoteRepository {
        return ListNoteRepositoryImpl(appDataBase)
    }

    @Provides
    fun useCaseBuilder(listRepository: ListNoteRepositoryImpl): IListNoteUseCase =
        ListNoteUseCaseImpl(listRepository)

}