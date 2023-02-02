package com.github.tumusx.core_data.mapper

import com.github.tumusx.core_data.local.entity.NoteEntity
import com.github.tumusx.note_list.domain.model.Note

object NoteMapper {

    fun converterToNoteToList(noteList: List<NoteEntity>): List<Note> =
        noteList.map { entity ->
            Note(
                entity.idNote,
                entity.noteText,
                entity.colorNote,
                entity.tittleNote,
                entity.lastEditor
            )
        }

    //TODO melhorar esse código

    fun converterToNote(entity: com.github.tumusx.feature_note_createupdate.domain.model.Note) = NoteEntity(
        entity.idNote,
        entity.noteText,
        entity.colorNote,
        entity.tittleNote,
        entity.lastEditor
    )

}