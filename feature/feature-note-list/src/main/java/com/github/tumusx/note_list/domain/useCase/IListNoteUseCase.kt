package com.github.tumusx.note_list.domain.useCase

import com.github.tumusx.core_database.ResultCommon
import com.github.tumusx.core_model.model.NoteVo
import kotlinx.coroutines.flow.Flow

interface IListNoteUseCase {
    suspend fun getListNote(): Flow<ResultCommon<List<NoteVo>>>
}