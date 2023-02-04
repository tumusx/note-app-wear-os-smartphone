package com.github.tumusx.feature_note_createupdate.domain.repository

import com.example.model.Note

interface INoteRepository {
    suspend fun saveNoteItem(note: Note) : Boolean
    suspend fun alterNoteItem(note: Note) : Boolean
}