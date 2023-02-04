package com.github.tumusx.note_list.domain.useCase

import com.example.model.Note
import com.github.tumusx.note_list.domain.result.ResultCommon
import kotlinx.coroutines.flow.Flow

interface IListNoteUseCase {
    suspend fun getListNote(): Flow<ResultCommon<List<Note>>>
}