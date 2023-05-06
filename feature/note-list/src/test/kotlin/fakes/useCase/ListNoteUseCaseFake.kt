package fakes.useCase

import com.example.model.Note
import com.github.tumusx.note_list.domain.result.ResultCommon
import com.github.tumusx.note_list.domain.result.TypeError
import com.github.tumusx.note_list.domain.useCase.IListNoteUseCase
import fakes.repository.ListNoteFakeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListNoteUseCaseFake(private val listNoteRepositoryFake: ListNoteFakeRepository) : IListNoteUseCase {
    override suspend fun getListNote(): Flow<ResultCommon<List<Note>>> = flow {
        try {
            val listNote = listNoteRepositoryFake.getAllNotes()
            emit(ResultCommon.Success(listNote))

/*            if (listNote.isEmpty()) {
                emit(ResultCommon.Error(TypeError.NO_DATA))
            } else {
                emit(ResultCommon.Success(listNote))
            }*/
        } catch (exception: Exception) {
            emit(ResultCommon.Error(TypeError.EXCEPTION))
        }
    }

}