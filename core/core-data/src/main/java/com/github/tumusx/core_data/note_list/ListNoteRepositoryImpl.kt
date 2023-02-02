package com.github.tumusx.core_data.note_list

import com.github.tumusx.core_data.mapper.NoteMapper
import com.github.tumusx.note_list.domain.model.Note
import com.github.tumusx.note_list.domain.repository.IListNoteRepository

class ListNoteRepositoryImpl<T>(private val dataSource: T) : IListNoteRepository {

    override suspend fun getAllNotes(): List<Note> {
        return NoteMapper.converterToNoteToList(emptyList())
    }
}