package com.github.tumusx.feature_note_createupdate.domain.repository

import com.github.tumusx.feature_note_createupdate.domain.model.Note

interface INoteRepository {
    suspend fun saveNoteItem(note: Note)
}