package viewModel

import InstantExecutorExtension
import com.github.tumusx.note_list.presenter.viewModel.ListNoteStateUI
import com.github.tumusx.note_list.presenter.viewModel.ListNoteViewModel
import com.github.tumusx.test_instrumented.getOrAwaitValueTest
import fakes.repository.ListNoteFakeRepository
import fakes.useCase.ListNoteUseCaseFake
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ListNoteViewModelTest : InstantExecutorExtension() {
    private lateinit var listNoteUseCaseFake: ListNoteUseCaseFake
    private val listNoteFakeRepository = ListNoteFakeRepository()
    private lateinit var viewModel: ListNoteViewModel

    @ExperimentalCoroutinesApi
    private val testDispatcher = StandardTestDispatcher()


    override fun setup() {
        Dispatchers.setMain(testDispatcher)
        listNoteUseCaseFake = ListNoteUseCaseFake(listNoteFakeRepository)
        viewModel = ListNoteViewModel(listNoteUseCaseFake, testDispatcher)
    }

    @Test
    fun `when call getListNote in viewModel, change value in object livedata with data list`() {
        viewModel.allListNote()
        val state = viewModel.noteState.getOrAwaitValueTest()
            assertEquals(
                ListNoteStateUI(success = ListNoteFakeRepository.noteList).success,
                state.success
            )
        }
}