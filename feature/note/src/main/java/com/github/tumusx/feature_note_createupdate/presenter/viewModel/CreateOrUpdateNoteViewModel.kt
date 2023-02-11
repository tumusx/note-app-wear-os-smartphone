package com.github.tumusx.feature_note_createupdate.presenter.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Note
import com.github.tumusx.feature_note_createupdate.domain.useCase.INoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StateUi(
    var error: String? = null,
    var success: Note? = null,
    var isLoading: Boolean = false
)

@HiltViewModel
class CreateOrUpdateNoteViewModel @Inject constructor(private val noteUseCase: INoteUseCase) : ViewModel() {
    private val _uiState: MutableStateFlow<StateUi> = MutableStateFlow(StateUi(isLoading = true))
    val uiState: StateFlow<StateUi> = _uiState


    fun createNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                noteUseCase.createNote(note)
            } catch (exception: Exception) {
                exception.printStackTrace()
                _uiState.value = StateUi(error = "Erro desconhecido")
            }
        }
    }

}