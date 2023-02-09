package com.github.tumusx.note_list.presenter.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Note
import com.github.tumusx.note_list.domain.result.ResultCommon
import com.github.tumusx.note_list.domain.result.TypeError
import com.github.tumusx.note_list.domain.useCase.IListNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ListNoteStateUI(
    var error: TypeError? = TypeError.NO_DATA,
    var success: List<Note>? = emptyList(),
    var isLoading: Boolean = false
)


@HiltViewModel
class ListNoteViewModel @Inject constructor(
    private val listNoteUseCaseImpl: IListNoteUseCase,
) : ViewModel() {
    private val _noteState: MutableStateFlow<ListNoteStateUI> =
        MutableStateFlow(ListNoteStateUI(isLoading = true))
    val noteState: StateFlow<ListNoteStateUI> = _noteState

/*
    val listNoteInMemory: StateFlow<List<Note>?> =
        savedStateHandle.getStateFlow("listNote", noteState.value.success)

    private fun setListNote(noteList: List<Note>) {
        savedStateHandle["listNote"] = noteList
    }
*/

    private fun allListNote() {
        viewModelScope.launch(Dispatchers.IO) {
            listNoteUseCaseImpl.getListNote().onEach { resultCommon ->
                when (resultCommon) {
                    is ResultCommon.Success -> _noteState.value =
                        ListNoteStateUI(success = resultCommon.data?.toList())
                    is ResultCommon.Error -> _noteState.value =
                        ListNoteStateUI(error = resultCommon.typeError)
                    is ResultCommon.Loading -> _noteState.value = ListNoteStateUI(isLoading = true)
                }
            }
        }
    }
}