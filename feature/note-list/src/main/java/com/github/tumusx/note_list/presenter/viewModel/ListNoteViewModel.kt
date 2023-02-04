package com.github.tumusx.note_list.presenter.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Note
import com.github.tumusx.note_list.domain.result.ResultCommon
import com.github.tumusx.note_list.domain.result.TypeError
import com.github.tumusx.note_list.domain.useCase.IListNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListNoteStateUI(
    var error: TypeError? = TypeError.NO_DATA,
    var success: List<Note>? = emptyList(),
    var isLoading: Boolean = false
)

class ListNoteViewModel(
    private val listNoteUseCaseImpl: IListNoteUseCase,
    private val coroutineContext: CoroutineContext,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _noteState: MutableStateFlow<ListNoteStateUI> =
        MutableStateFlow(ListNoteStateUI(isLoading = true))
    val noteState: StateFlow<ListNoteStateUI> = _noteState

    val listNoteInMemory: StateFlow<List<Note>?> =
        savedStateHandle.getStateFlow("listNote", noteState.value.success)

    private fun setListNote(noteList: List<Note>) {
        savedStateHandle["listNote"] = noteList
    }

    private fun allListNote() {
        viewModelScope.launch(coroutineContext) {
            listNoteUseCaseImpl.getListNote().onEach { resultCommon ->
                when (resultCommon) {
                    is ResultCommon.Success -> _noteState.value =
                        ListNoteStateUI(success = resultCommon.data?.toList()).also { stateUi ->
                            stateUi.success?.let { noteItems -> setListNote(noteItems) }
                        }
                    is ResultCommon.Error -> _noteState.value =
                        ListNoteStateUI(error = resultCommon.typeError)
                    is ResultCommon.Loading -> _noteState.value = ListNoteStateUI(isLoading = true)
                }
            }
        }
    }
}