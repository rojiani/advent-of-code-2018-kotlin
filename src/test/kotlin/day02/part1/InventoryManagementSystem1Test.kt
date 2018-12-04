package day02.first

import common.inputFilenameForDay
import org.junit.Test

import org.junit.Assert.*

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