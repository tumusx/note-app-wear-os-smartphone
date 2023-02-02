package com.github.tumusx.note_list.domain.repository

import com.github.tumusx.note_list.domain.model.Note

interface IListNoteRepository {
    suspend fun getAllNotes() : List<Note>?
}