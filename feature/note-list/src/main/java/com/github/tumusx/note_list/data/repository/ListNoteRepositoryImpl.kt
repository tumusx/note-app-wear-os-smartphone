package com.github.tumusx.note_list.data.repository

import android.util.Log
import com.example.database.database.AppDataBase
import com.example.model.Note
import com.github.tumusx.note_list.data.mapper.NoteMapper
import com.github.tumusx.note_list.domain.repository.IListNoteRepository
import javax.inject.Inject

class ListNoteRepositoryImpl @Inject constructor(private val dataBase: AppDataBase) : IListNoteRepository {
    override suspend fun getAllNotes(): List<Note>? {
        return try {
            Log.d("VAIIIIIII", "PEGANDOOOO")
            NoteMapper.noteFromList(dataBase.listDao.getAllListItem())
        } catch (exception: Exception) {
            exception.printStackTrace()
            Log.d("VAIIIIIII", "NAO PEGANOOOO")
            return null
        }
    }

    override suspend fun deleteNote(note: Note): Boolean {
        return try {
            dataBase.listDao.deleteNote(NoteMapper.noteEntityFrom(note))
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }
}