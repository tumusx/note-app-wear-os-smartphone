package com.example.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.database.entity.NoteEntity

@Dao
interface ListNoteDao{

    @Query("SELECT *FROM note")
    suspend fun getAllListItem() : List<NoteEntity>

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}