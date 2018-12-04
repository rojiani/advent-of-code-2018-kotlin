package day01.part1

import common.inputFilenameForDay
import org.junit.Assert.assertEquals
import org.junit.Test

class ChronalCalibration1Test {

    @Test
    fun findResultingFrequency() {
        assertEquals(592, Day1Part1.findResultingFrequency(inputFilenameForDay(1)))
    }
}