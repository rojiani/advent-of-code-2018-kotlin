package day02.part1

import common.inputFilenameForDay
import org.junit.Assert.assertEquals
import org.junit.Test

class InventoryManagementSystem1Test {

    @Test
    fun calculateChecksumForInput() {
        assertEquals(7470, Day2Part1.calculateChecksumForInput(inputFilenameForDay(2)))
    }

    @Test
    fun calculateChecksum() {
        assertEquals(
            12,
            Day2Part1.calculateChecksum(
                listOf(
                    "abcdef",
                    "bababc",
                    "abbcde",
                    "abcccd",
                    "aabcdd",
                    "abcdee",
                    "ababab"
                )
            )
        )
    }
}