package com.github.tumusx.note_list.data.mapper

import com.example.database.entity.NoteEntity
import com.example.model.Note

object NoteMapper {
    fun noteFrom(noteEntity: NoteEntity) = Note(
        noteEntity.idNote,
        noteEntity.noteText,
        noteEntity.colorNote,
        noteEntity.tittleNote,
        noteEntity.lastEditor
    )

    fun noteEntityFrom(note: Note) =
        NoteEntity(note.idNote, note.noteText, note.colorNote, note.tittleNote, note.lastEditor)

    fun noteEntityFromList(noteList: List<Note>) = noteList.map { note ->
        NoteEntity(note.idNote, note.noteText, note.colorNote, note.tittleNote, note.lastEditor)
    }

    fun noteFromList(noteEntityList: List<NoteEntity>) = noteEntityList.map { noteEntity ->
        Note(
            noteEntity.idNote,
            noteEntity.noteText,
            noteEntity.colorNote,
            noteEntity.tittleNote,
            noteEntity.lastEditor
        )
    }
}