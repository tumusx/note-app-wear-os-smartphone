package com.github.tumusx.feature_note_createupdate.domain.useCase

import com.example.model.Note

interface INoteUseCase {
    suspend fun createNote(note: Note)
    suspend fun alterNote(note: Note)
}