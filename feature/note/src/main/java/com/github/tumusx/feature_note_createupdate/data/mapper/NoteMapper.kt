package com.github.tumusx.feature_note_createupdate.data.mapper

import com.example.database.entity.NoteEntity
import com.example.model.Note
import com.github.tumusx.core_navigation.model.NoteNavVO


fun Note.noteMapper(): NoteEntity = NoteEntity(
    this.idNote,
    this.noteText.toString(),
    this.colorNote,
    this.tittleNote.toString(),
    this.lastEditor.toString()
)

fun Note.noteVoNavigateMapper() = NoteNavVO(
    this.idNote,
    this.noteText,
    this.colorNote,
    this.tittleNote,
    this.lastEditor
)