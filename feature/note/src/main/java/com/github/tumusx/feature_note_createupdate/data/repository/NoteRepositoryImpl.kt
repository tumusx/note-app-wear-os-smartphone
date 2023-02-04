package com.github.tumusx.feature_note_createupdate.data.repository

import com.example.database.database.AppDataBase
import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.domain.repository.INoteRepository

class NoteRepositoryImpl(private val database: AppDataBase) : INoteRepository {

    override suspend fun saveNoteItem(note: Note): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun alterNoteItem(note: Note): Boolean {
        TODO("Not yet implemented")
    }
}