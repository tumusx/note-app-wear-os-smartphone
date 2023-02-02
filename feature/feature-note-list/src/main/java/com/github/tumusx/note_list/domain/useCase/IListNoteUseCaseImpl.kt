package com.github.tumusx.note_list.domain.useCase

import com.github.tumusx.core_database.ResultCommon
import com.github.tumusx.note_list.domain.model.Note
import com.github.tumusx.note_list.domain.repository.IListNoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IListNoteUseCaseImpl(private val iListNoteRepository: IListNoteRepository) :
    IListNoteUseCase {
    override suspend fun getListNote(): Flow<ResultCommon<List<Note>>> = flow {
        val resultCommon = iListNoteRepository.getAllNotes()
        //todo remover quando integrar com banco de dados
        try {
            if (resultCommon?.isEmpty() == true || resultCommon == null) {
                emit(ResultCommon.Error("Sem nenhum resultado!"))
                return@flow
            }
            emit(ResultCommon.Success(emptyList()))
        } catch (error: Exception) {
            emit(ResultCommon.Error(Exception(message = "erro desconhecido").message.toString()))
            error.printStackTrace()
        }
    }
}