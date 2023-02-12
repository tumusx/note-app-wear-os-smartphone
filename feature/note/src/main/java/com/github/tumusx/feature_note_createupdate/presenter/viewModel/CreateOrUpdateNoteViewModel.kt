package com.github.tumusx.feature_note_createupdate.presenter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.domain.useCase.INoteUseCase
import com.github.tumusx.feature_note_createupdate.domain.useCase.StatusNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StateUi(
    var messageError: String? = null,
    var messageSuccess: String? = null,
    var isLoading: Boolean = false
)

@HiltViewModel
class CreateOrUpdateNoteViewModel @Inject constructor(private val noteUseCase: INoteUseCase) :
    ViewModel() {
    private val _uiState: MutableLiveData<StateUi> = MutableLiveData(StateUi(isLoading = true))
    val uiState: LiveData<StateUi> = _uiState


    fun createNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                noteUseCase.createNote(note).collect { statusNote ->
                    if (statusNote is StatusNote.Success) {
                        _uiState.postValue(StateUi(messageSuccess = statusNote.messageSuccess))
                    } else {
                        _uiState.postValue(StateUi(messageError = (statusNote as StatusNote.Error).messageError))
                    }
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
                _uiState.value = StateUi(messageError = "Erro desconhecido")
            }
        }
    }

}