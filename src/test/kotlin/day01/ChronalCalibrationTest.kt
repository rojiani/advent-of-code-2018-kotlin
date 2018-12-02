package day01

import org.junit.Test

import org.junit.Assert.*

class ChronalCalibrationTest {

    @Test
    fun firstRepeatedFrequency() {
        assertEquals(2, findFirstRepeatedFrequency(listOf(1, -2, 3, 1)))
        assertEquals(0, findFirstRepeatedFrequency(listOf(1, -1)))
        assertEquals(10, findFirstRepeatedFrequency(listOf(3, 3, 4, -2, -4)))
        assertEquals(5, findFirstRepeatedFrequency(listOf(-6, 3, 8, 5, -6)))
        assertEquals(14, findFirstRepeatedFrequency(listOf(7, 7, -2, -7, -4)))
    }
}