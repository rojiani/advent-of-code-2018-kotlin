package common

import org.junit.Test

import org.junit.Assert.*

class IOTest {

    @Test
    fun `test inputFilenameForDay`() {
        assertEquals(
            "src/main/resources/input/day_01_input.txt",
            inputFilenameForDay(1)
        )

        assertEquals(
            "src/main/resources/input/day_14_input.txt",
            inputFilenameForDay(14)
        )
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test inputFilenameForDay with invalid day`() {
        inputFilenameForDay(26)
    }
}