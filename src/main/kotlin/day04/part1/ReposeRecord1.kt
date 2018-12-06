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

    fun solve(): Int {
        /* Parse entries, convert to GuardLogEntry, sort by time, & fill in guardIDs
           to entries not associated with one. */
        val entriesByID = groupInputByGuardID()
        val sleepiestGuardID = findSleepiestGuard(entriesByID)
        val minute = findMostSleptMinute(entriesByID[sleepiestGuardID]!!)

        return sleepiestGuardID * minute
    }

    /**
     * This method prepares the input to solve Part 1 & Part 2 by doing the following:
     * 1. Read the entries in the input file
     * 2. Creates a [GuardLogEntry] for each entry (i.e., each line)
     * 3. Sorts the entries chronologically
     * 4. Associates a Guard ID with each entry (cannot be done until sorted)
     * 5. Groups the entries by Guard ID
     */
    internal fun groupInputByGuardID(): Map<Int, List<GuardLogEntry>> = parseInputLogs()
        .sortedBy { it.time }
        .run(::addGuardIDs)
        .groupBy { it.guardID!! }

    /** Associate the proper guard IDs with entries with "falls asleep" and "wakes up" events */
    internal fun addGuardIDs(sortedEntries: List<GuardLogEntry>): List<GuardLogEntry> {
        var currentGuardID: Int = sortedEntries.first().guardID!!
        return sortedEntries.map { entry ->
            if (entry.event == GuardAction.CHECK_IN) {
                currentGuardID = entry.guardID!!
            }

            if (entry.guardID != null) entry
            else entry.copy(guardID = currentGuardID)
        }
    }

    internal fun findSleepiestGuard(entriesByID: Map<Int, List<GuardLogEntry>>): Int {
        val sleepTimes: MutableMap<Int, Int> = HashMap()
        for ((id, entriesForID) in entriesByID) {
            var minsSlept = 0
            for (i in entriesForID.indices) {
                if (entriesForID[i].event == GuardAction.FALLS_ASLEEP) {
                    minsSlept += minsSleptBetween(entriesForID[i].time, entriesForID[i + 1].time)
                }
            }
            sleepTimes[id] = minsSlept
        }

        return sleepTimes.maxBy { (_, totalTimeSlept) -> totalTimeSlept }!!.key
    }

    internal fun findMostSleptMinute(guardEntries: List<GuardLogEntry>): Int {
        require(guardEntries.isNotEmpty()) { "guardEntries must not be empty" }

        val timesAsleepDuringMinute = IntArray(60)
        guardEntries.forEachIndexed { i, entry ->
            if (entry.event == GuardAction.FALLS_ASLEEP) {
                val startMin = entry.time.minute
                val endMin = guardEntries[i + 1].time.minute
                (startMin until endMin).forEach { m ->
                    timesAsleepDuringMinute[m]++
                }
            }
        }

        return timesAsleepDuringMinute.withIndex()
            .maxBy { (_, timesAsleep) ->
                timesAsleep
            }!!.index
    }

    /** Read the input file and create a [GuardLogEntry] for each line. */
    private fun parseInputLogs(): List<GuardLogEntry> = File(DAY_4_INPUT_FILENAME).readLines()
        .map { record -> GuardLogEntry.from(record) }

    // Note: in the input, every sleep event is followed by a wake event for the same guard
    private fun minsSleptBetween(sleepDateTime: LocalDateTime, wakeDateTime: LocalDateTime): Int =
        Duration.between(
            sleepDateTime.toLocalTime(),
            wakeDateTime.toLocalTime()
        ).toMinutes().toInt()

}

fun main(args: Array<String>) {
    println(Day4Part1.solve())
}