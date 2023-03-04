package com.github.tumusx.feature_note_createupdate.domain.useCase

import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

sealed class StatusNote {
    data class Error(val messageError: String) : StatusNote()
    data class Success(val messageSuccess: String) : StatusNote()

}

class ValidateNote(private val note: Note) {
    fun validateNotes(): String {
        if (note.noteText?.isEmpty() == true || note.noteText == null) {
            return "Hey! Para salvar uma nota, é necessário digitar nos campo."
        }
        if (note.tittleNote?.isEmpty() == true || note.tittleNote == null) {
            return "Hey! É necessário preencher um título legal para a sua nota, não acha?\nSem isso, não será possível salvar ela!"
        }

        return ""
    }
}

class NoteUseCaseImpl @Inject constructor(private val iNoteRepository: INoteRepository) :
    INoteUseCase {
    override suspend fun createNote(note: Note): Flow<StatusNote> = flow {
        try {
            val validateNote = ValidateNote(note).validateNotes()
            if (validateNote.isEmpty()) {
                iNoteRepository.saveNoteItem(note).also {
                    emit(StatusNote.Success("Salvo com sucesso"))
                }
            } else {
                emit(StatusNote.Error(validateNote))
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(StatusNote.Error("Erro em salvar. Tente novamente mais tarde!"))
        }
    }

    override suspend fun alterNote(note: Note) : Flow<StatusNote> = flow{
        try {
            iNoteRepository.alterNoteItem(note)
            emit(StatusNote.Success("Atualizado com sucesso!"))
        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(StatusNote.Error("Erro em atualizar. Tente novamente mais tarde!"))
        }
    }
}