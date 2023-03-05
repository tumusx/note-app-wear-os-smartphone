package viewModel

import InstantExecutorExtension
import com.github.tumusx.note_list.domain.result.TypeError
import com.github.tumusx.note_list.presenter.viewModel.ListNoteStateUI
import com.github.tumusx.note_list.presenter.viewModel.ListNoteViewModel
import fakes.repository.ListNoteFakeRepository
import fakes.useCase.ListNoteUseCaseFake
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher
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
        listNoteFakeRepository.isEmptyList = true
        viewModel.allListNote().also {
            assertEquals(
                viewModel.noteState.value?.success,
                ListNoteStateUI(success = ListNoteFakeRepository.noteList)
            )
        }
    }
}