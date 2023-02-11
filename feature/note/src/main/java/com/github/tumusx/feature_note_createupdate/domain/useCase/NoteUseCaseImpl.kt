package com.github.tumusx.feature_note_createupdate.domain.useCase

import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.domain.repository.INoteRepository
import javax.inject.Inject

class NoteUseCaseImpl @Inject constructor(private val iNoteRepository: INoteRepository) :
    INoteUseCase {
    override suspend fun createNote(note: Note) {
        try {
            iNoteRepository.saveNoteItem(note)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    override suspend fun alterNote(note: Note) {
        try {
            iNoteRepository.alterNoteItem(note)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}