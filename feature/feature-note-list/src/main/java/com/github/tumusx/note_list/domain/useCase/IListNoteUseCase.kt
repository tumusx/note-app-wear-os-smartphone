package com.github.tumusx.note_list.domain.useCase

import com.github.tumusx.core_database.ResultCommon
import com.github.tumusx.note_list.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface IListNoteUseCase {
    suspend fun getListNote(): Flow<ResultCommon<List<Note>>>
}