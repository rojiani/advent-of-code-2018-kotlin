package day04.part2

import day04.GuardAction
import day04.GuardLogEntry
import day04.part1.Day4Part1

/**
 * [Day 4, Part 2](https://adventofcode.com/2018/day/4#part2)
 */
object Day4Part2 {

    fun solve(): Int = solveForGroupedEntries(Day4Part1.groupInputByGuardID())

    internal fun solveForGroupedEntries(entriesByID: Map<Int, List<GuardLogEntry>>): Int {
        // Create map of GuardID => (Minute, # times asleep at Minute)
        val mostSleptByID: MutableMap<Int, Pair<Int, Int>> =
            entriesByID.entries.fold(hashMapOf()) { acc, (guardID, guardEntries) ->
                acc.apply {
                    acc[guardID] = findMostSleptMinuteAndCount(guardEntries)
                }
            }

        val (guardID, minuteAndCount) = mostSleptByID.maxBy { (_, sleepInfo) ->
            sleepInfo.second
        }!!

        return guardID * minuteAndCount.first
    }

    internal fun findMostSleptMinuteAndCount(guardEntries: List<GuardLogEntry>): Pair<Int, Int> {
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

        val mostSlept = timesAsleepDuringMinute.withIndex()
            .maxBy { (_, timesAsleep) ->
                timesAsleep
            }!!
        return Pair(mostSlept.index, mostSlept.value)
    }

}

fun main(args: Array<String>) {
    println(Day4Part2.solve())
}