package day05.part1

import org.junit.Test

import org.junit.Assert.*

class Day5Part1Test {

    @Test
    fun solve() {
        assertEquals(11108, Day5Part1.solve())
    }

    @Test
    fun alchemicallyReduce() {
        assertEquals("", Day5Part1.alchemicallyReduce("aA"))
        assertEquals("", Day5Part1.alchemicallyReduce("Aa"))
        assertEquals("a", Day5Part1.alchemicallyReduce("a"))
        assertEquals("a", Day5Part1.alchemicallyReduce("aAa"))
        assertEquals("dabCBAcaDA", Day5Part1.alchemicallyReduce("dabAcCaCBAcCcaDA"))
    }
}