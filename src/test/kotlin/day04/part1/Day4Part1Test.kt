package day04.part1

import day04.GuardLogEntry
import org.junit.Test

import org.junit.Assert.*

class Day4Part1Test {
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

    val sampleEntries: List<GuardLogEntry> = sampleRecords.map { entry ->
        GuardLogEntry.from(entry)
    }

    @Test
    fun solve() {
        TODO()
    }

    @Test
    fun addGuardIDs() {
        assertFalse(sampleEntries.all { it.guardID != null })

        val withIDs = Day4Part1.addGuardIDs(sampleEntries)
        assertTrue(withIDs.all { it.guardID != null })
        assertEquals(
            listOf(
                10, 10, 10, 10, 10,
                99, 99, 99,
                10, 10, 10,
                99, 99, 99,
                99, 99, 99
            ),
            withIDs.map { it.guardID }
        )
    }

    @Test
    fun findSleepiestGuard() {
        val withIDs = Day4Part1.addGuardIDs(sampleEntries)
        assertEquals(10, Day4Part1.findSleepiestGuard(withIDs))
        val inputEntries = Day4Part1.addGuardIDs(
            Day4Part1.parseInputLogs()
                .sortedBy { it.time }
        )
        assertEquals(863, Day4Part1.findSleepiestGuard(inputEntries))
    }
}