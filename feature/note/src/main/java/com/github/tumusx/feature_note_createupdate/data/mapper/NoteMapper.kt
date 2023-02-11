package com.github.tumusx.feature_note_createupdate.data.mapper

import com.example.database.entity.NoteEntity
import com.example.model.Note


fun Note.noteMapper(): NoteEntity = NoteEntity(
    this.idNote, this.noteText, this.colorNote, this.tittleNote, this.lastEditor
)