import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.File.separator
import java.io.PrintStream
import java.lang.System.setOut
import java.nio.file.InvalidPathException
import kotlin.test.assertContains

internal class MainKtTest {

    @Test
    fun mainShouldPrintInfo() {
        val outBuffer = ByteArrayOutputStream()
        setOut(PrintStream(outBuffer))

        main(arrayOf("--path=src/test/resources"))

        val out = outBuffer.toString()
        assert(out.contains("src${separator}test${separator}resources"))
        assert(out.contains("Can write"))
        assert(out.contains("Can read"))
        assert(out.contains("Can execute"))
    }

    @Test
    fun mainShouldNotPrintInfoWhenPathNotExist() {
        val invalidPath = "src${separator}test${separator}resourcesasdasd"
        val out = ByteArrayOutputStream()
        setOut(PrintStream(out))

        val exception = assertThrows<InvalidPathException> {
            main(arrayOf("--path=$invalidPath"))
        }
        assertContains(exception.message ?: "", "Path does not exist")
        assertContains(exception.message ?: "", invalidPath)
    }

    @Test
    fun mainShouldNotPrintInfoWhenPathNotSpecified() {
        val out = ByteArrayOutputStream()
        setOut(PrintStream(out))

        val exception = assertThrows<IllegalArgumentException> {
            main(arrayOf())
        }
        assertContains(exception.message ?: "", "No path argument specified")
    }

    @Test
    fun mainShouldNotPrintInfoWhenPathIsEmpty() {
        val out = ByteArrayOutputStream()
        setOut(PrintStream(out))

        val exception = assertThrows<IllegalArgumentException> {
            main(arrayOf("--path="))
        }
        
        assertContains(exception.message ?: "", "Path cannot be empty")
    }
}