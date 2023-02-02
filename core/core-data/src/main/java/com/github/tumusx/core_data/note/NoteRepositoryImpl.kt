package com.github.tumusx.core_data.note

import com.github.tumusx.core_data.mapper.NoteMapper
import com.github.tumusx.feature_note_createupdate.domain.model.Note
import com.github.tumusx.feature_note_createupdate.domain.repository.INoteRepository

class NoteRepositoryImpl<T>(private val database: T) : INoteRepository{
    override suspend fun saveNoteItem(note: Note) {
        NoteMapper.converterToNote(note)
    }
}