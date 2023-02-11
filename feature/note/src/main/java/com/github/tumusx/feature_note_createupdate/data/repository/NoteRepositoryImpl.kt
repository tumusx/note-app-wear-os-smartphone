package com.github.tumusx.feature_note_createupdate.data.repository

import com.example.database.database.AppDataBase
import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.data.mapper.noteMapper
import com.github.tumusx.feature_note_createupdate.domain.repository.INoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val database: AppDataBase) : INoteRepository {


    override suspend fun saveNoteItem(note: Note) = database.noteDao.insertNote(note.noteMapper())

    override suspend fun alterNoteItem(note: Note) = database.noteDao.alterNote(note.noteMapper())
}