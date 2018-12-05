package day04.part1

import common.inputFilenameForDay
import day04.GuardAction
import day04.GuardLogEntry
import java.io.File
import java.time.Duration
import java.time.LocalDateTime

private val DAY_4_INPUT_FILENAME = inputFilenameForDay(4)

/**
 * [Day 4, Part 1](https://adventofcode.com/2018/day/4)
 */
object Day4Part1 {

    fun solve() {
        val entries = parseInputLogs()
            .sortedBy { it.time }
            .run(::addGuardIDs)

        val sleepiestGuardID = findSleepiestGuard(entries)
        println("sleepiestGuardID: $sleepiestGuardID")
        // TODO - calculate minute most slept
    }

    /** Associate the proper guard IDs with entries with "falls asleep" and "wakes up" events */
    internal fun addGuardIDs(sortedEntries: List<GuardLogEntry>): List<GuardLogEntry> {
        requireNotNull(sortedEntries.first().guardID) {
            "The first entry in a sorted list of entries should have a guardID"
        }

        var lastID: Int = sortedEntries.first().guardID!!
        return sortedEntries.map { entry ->
            if (entry.event == GuardAction.CHECK_IN) {
                lastID = entry.guardID!!
            }

            if (entry.guardID != null) entry
            else entry.copy(guardID = lastID)
        }
    }

    /**
     * @param entries Sorted entries with all Guard IDs assigned
     * @return The ID of the guard who slept the most total minutes.
     */
    internal fun findSleepiestGuard(entries: List<GuardLogEntry>): Int {
        val entriesByID = entries.groupBy { it.guardID }
        val sleepTimes: MutableMap<Int, Int> = HashMap()
        for ((id, entriesForID) in entriesByID) {
            var minsSlept = 0
            for (i in entriesForID.indices) {
                if (entriesForID[i].event == GuardAction.FALLS_ASLEEP) {
                    minsSlept += minsSleptBetween(entriesForID[i].time, entriesForID[i + 1].time)
                }
            }
            sleepTimes[id!!] = minsSlept
        }
        println(sleepTimes)
        return sleepTimes.maxBy { (_, totalTimeSlept) -> totalTimeSlept }?.key
            ?: error("Programming error calculating sleepiest guard")
    }

    // Note: in the input, every sleep event is followed by a wake event for the same guard
    private fun minsSleptBetween(sleepDateTime: LocalDateTime, wakeDateTime: LocalDateTime): Int =
        Duration.between(
            sleepDateTime.toLocalTime(),
            wakeDateTime.toLocalTime()
        ).toMinutes().toInt()

    /** Read the input file and create a [GuardLogEntry] for each line. */
    internal fun parseInputLogs(): List<GuardLogEntry> = File(DAY_4_INPUT_FILENAME).readLines()
        .map { record -> GuardLogEntry.from(record) }
}

fun main(args: Array<String>) {
    Day4Part1.solve()
}