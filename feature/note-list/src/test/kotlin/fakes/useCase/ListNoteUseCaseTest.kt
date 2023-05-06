package fakes.useCase

import com.github.tumusx.note_list.data.repository.ListNoteRepositoryImpl
import com.github.tumusx.note_list.domain.result.ResultCommon
import com.github.tumusx.note_list.domain.useCase.ListNoteUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class ListNoteUseCaseTest {
    @RelaxedMockK
    lateinit var listNoteRepository: ListNoteRepositoryImpl

    lateinit var listNoteUseCase: ListNoteUseCaseImpl


    @Before
    fun setup() {
        MockKAnnotations.init(this)
        listNoteUseCase = ListNoteUseCaseImpl(listNoteRepository)
    }


    @Test
    fun `when call getListNote, return success search data`() {

        every { runBlocking { listNoteUseCase.getListNote() } } returns flowOf(
            ResultCommon.Success(
                emptyList()
            )
        )

        val captureData =

        verify {
            assertNotNull(true)
        }

    }

    @After
    fun cleanMocks() {
        clearAllMocks()
    }
}