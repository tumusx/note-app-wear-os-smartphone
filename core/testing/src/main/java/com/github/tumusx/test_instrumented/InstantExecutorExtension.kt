import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule

abstract class InstantExecutorExtension {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    abstract fun setup()
}
