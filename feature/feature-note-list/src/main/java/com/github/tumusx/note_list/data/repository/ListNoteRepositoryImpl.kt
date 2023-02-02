package com.github.tumusx.note_list.data.repository

import com.github.tumusx.core_data.model.NoteVo
import com.github.tumusx.note_list.domain.repository.IListNoteRepository

class ListNoteRepositoryImpl : IListNoteRepository{
    override suspend fun getAllNotes() = emptyList<NoteVo>()
}