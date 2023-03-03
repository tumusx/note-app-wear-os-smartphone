package com.github.tumusx.note_list.data.mapper

import com.example.database.entity.NoteEntity
import com.example.model.Note

object NoteMapper {
    fun noteEntityFrom(note: Note) =
        NoteEntity(note.idNote, note.noteText.toString(), note.colorNote.toString(), note.tittleNote.toString(), note.lastEditor.toString())

    fun noteFromList(noteEntityList: List<NoteEntity>) = noteEntityList.map { noteEntity ->
        Note(
            noteEntity.idNote,
            noteEntity.noteText,
            noteEntity.colorNote.toString(),
            noteEntity.tittleNote,
            noteEntity.lastEditor
        )
    }
}