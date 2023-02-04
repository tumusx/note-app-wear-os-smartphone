package com.github.tumusx.note_list.domain.useCase

import com.example.model.Note
import com.github.tumusx.note_list.domain.repository.IListNoteRepository
import com.github.tumusx.note_list.domain.result.ResultCommon
import com.github.tumusx.note_list.domain.result.TypeError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListNoteUseCaseImpl(private val iListNoteRepository: IListNoteRepository) :
    IListNoteUseCase {
    override suspend fun getListNote(): Flow<ResultCommon<List<Note>>> = flow {
        val resultCommon = iListNoteRepository.getAllNotes()
        try {
            if (resultCommon?.isEmpty() == true || resultCommon == null) {
                emit(ResultCommon.Error(TypeError.NO_DATA))
                return@flow
            }
            emit(ResultCommon.Success(resultCommon))
        } catch (error: Exception) {
            emit(ResultCommon.Error(TypeError.EXCEPTION))
            error.printStackTrace()
        }
    }
}