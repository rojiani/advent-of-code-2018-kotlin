package day04.part2

import day04.GuardLogEntry
import day04.part1.Day4Part1
import org.junit.Assert.assertEquals
import org.junit.Test

class ReposeRecord2Test {

    private val sampleRecords = listOf(
        "[1518-11-01 00:00] Guard #10 begins shift",
        "[1518-11-01 00:05] falls asleep",
        "[1518-11-01 00:25] wakes up",
        "[1518-11-01 00:30] falls asleep",
        "[1518-11-01 00:55] wakes up",
        "[1518-11-01 23:58] Guard #99 begins shift",
        "[1518-11-02 00:40] falls asleep",
        "[1518-11-02 00:50] wakes up",
        "[1518-11-03 00:05] Guard #10 begins shift",
        "[1518-11-03 00:24] falls asleep",
        "[1518-11-03 00:29] wakes up",
        "[1518-11-04 00:02] Guard #99 begins shift",
        "[1518-11-04 00:36] falls asleep",
        "[1518-11-04 00:46] wakes up",
        "[1518-11-05 00:03] Guard #99 begins shift",
        "[1518-11-05 00:45] falls asleep",
        "[1518-11-05 00:55] wakes up"
    )
    private val sampleEntries: List<GuardLogEntry> = sampleRecords.map(GuardLogEntry.Companion::from)
    private val sampleEntriesByID: Map<Int, List<GuardLogEntry>> = Day4Part1.addGuardIDs(sampleEntries).groupBy { it.guardID!! }

    @Test
    fun solve() {
        assertEquals(14920, Day4Part2.solve())
    }

    @Test
    fun `solveForGroupedEntries - sample`() {
        assertEquals(4455, Day4Part2.solveForGroupedEntries(sampleEntriesByID))
    }

    @Test
    fun findMostSleptMinuteAndCount() {
        assertEquals(24 to 2, Day4Part2.findMostSleptMinuteAndCount(sampleEntriesByID[10]!!))
        assertEquals(45 to 3, Day4Part2.findMostSleptMinuteAndCount(sampleEntriesByID[99]!!))
    }

}