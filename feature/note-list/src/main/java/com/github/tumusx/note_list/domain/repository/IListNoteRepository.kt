package com.github.tumusx.note_list.domain.repository

import com.example.model.Note

interface IListNoteRepository {
    suspend fun getAllNotes() : List<Note>?

    suspend fun deleteNote(note: Note) : Boolean
}