package com.github.tumusx.note_list.domain.repository

import com.github.tumusx.core_model.model.NoteVo

interface IListNoteRepository {
    suspend fun getAllNotes() : List<NoteVo>?
}