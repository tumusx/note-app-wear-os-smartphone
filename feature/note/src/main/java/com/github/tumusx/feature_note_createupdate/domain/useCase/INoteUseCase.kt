package com.github.tumusx.feature_note_createupdate.domain.useCase

import com.example.model.Note
import kotlinx.coroutines.flow.Flow

interface INoteUseCase {
    suspend fun createNote(note: Note) : Flow<StatusNote>
    suspend fun alterNote(note: Note) : Flow<StatusNote>
}