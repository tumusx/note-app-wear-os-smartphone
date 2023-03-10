package com.github.tumusx.note_list.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Note
import com.github.tumusx.note_list.di.IoDispatcher
import com.github.tumusx.note_list.domain.result.ResultCommon
import com.github.tumusx.note_list.domain.result.TypeError
import com.github.tumusx.note_list.domain.useCase.IListNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListNoteStateUI(
    var error: TypeError? = TypeError.NO_DATA,
    var success: List<Note>? = emptyList(),
    var isLoading: Boolean = false
)

data class StateSearchItem(var errorMessage: String? = null, var dataResult: List<Note>? = null)

@HiltViewModel
class ListNoteViewModel @Inject constructor(
    private val listNoteUseCaseImpl: IListNoteUseCase,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _noteState: MutableLiveData<ListNoteStateUI> =
        MutableLiveData(ListNoteStateUI(isLoading = true))
    val noteState: LiveData<ListNoteStateUI> = _noteState

    init {
        allListNote()
    }

    fun allListNote() {
        viewModelScope.launch(coroutineDispatcher) {
            listNoteUseCaseImpl.getListNote().collect { resultCommon ->
                when (resultCommon) {
                    is ResultCommon.Success -> _noteState.postValue(
                        ListNoteStateUI(success = resultCommon.data?.toList())
                    )
                    is ResultCommon.Error -> _noteState.postValue(
                        ListNoteStateUI(error = resultCommon.typeError)
                    )
                    is ResultCommon.Loading -> _noteState.postValue(ListNoteStateUI(isLoading = true))
                }
            }
        }
    }
}