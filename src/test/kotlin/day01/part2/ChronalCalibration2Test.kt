package day01.part2

import org.junit.Assert.assertEquals
import org.junit.Test

class ChronalCalibration2Test {

    @Test
    fun solve() {
        assertEquals(241, Day1Part2.solve())
    }
    
    @Test
    fun findFirstRepeatedFrequency() {
        assertEquals(2, Day1Part2.findFirstRepeatedFrequency(listOf(1, -2, 3, 1)))
        assertEquals(0, Day1Part2.findFirstRepeatedFrequency(listOf(1, -1)))
        assertEquals(10, Day1Part2.findFirstRepeatedFrequency(listOf(3, 3, 4, -2, -4)))
        assertEquals(5, Day1Part2.findFirstRepeatedFrequency(listOf(-6, 3, 8, 5, -6)))
        assertEquals(14, Day1Part2.findFirstRepeatedFrequency(listOf(7, 7, -2, -7, -4)))
    }
}