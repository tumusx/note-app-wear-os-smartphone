package com.github.tumusx.note_list.data.repository

import com.example.database.database.AppDataBase
import com.example.model.Note
import com.github.tumusx.note_list.data.mapper.NoteMapper
import com.github.tumusx.note_list.domain.repository.IListNoteRepository

class ListNoteRepositoryImpl(private val dataBase: AppDataBase) : IListNoteRepository {
    override suspend fun getAllNotes(): List<Note>? {
        return try {
            NoteMapper.noteFromList(dataBase.listDao().getAllListItem())
        } catch (exception: Exception) {
            exception.printStackTrace()
            return null
        }
    }

    override suspend fun deleteNote(note: Note): Boolean {
        return try {
            dataBase.listDao().deleteNote(NoteMapper.noteEntityFrom(note))
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }
}