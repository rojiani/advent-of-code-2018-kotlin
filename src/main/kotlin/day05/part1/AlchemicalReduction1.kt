package day05.part1

import common.inputFilenameForDay
import java.io.File

private val DAY_5_INPUT_FILENAME = inputFilenameForDay(5)

/**
 * [Day 5, Part 1](https://adventofcode.com/2018/day/5)
 */
object Day5Part1 {
    fun solve() = alchemicallyReduce(readInput()).length

    fun readInput(): String = File(DAY_5_INPUT_FILENAME).readLines().single()

    tailrec fun alchemicallyReduce(polymer: String, previousPolymer: String = ""): String = when {
        previousPolymer.length == polymer.length -> polymer
        else -> alchemicallyReduce(reduceAllNeighbors(polymer), polymer)
    }

    /**
     * Does a single pass, removing adjacent reactive pairs, and returns the resulting String,
     * which may have adjacent reactive pairs (e.g., "abBA" -> "aA")
     */
    private fun reduceAllNeighbors(polymer: String): String = StringBuilder().run {
        // "abBA" -> [ab, bB, BA, A]
        val windows = polymer.windowed(
            size = 2,
            step = 1,
            partialWindows = true
        )

        var i = 0
        while (i < windows.size) {
            val currentWindow = windows[i]

            if (currentWindow.length == 1) {
                return append(currentWindow).toString()
            }

            when {
                !currentWindow.isReactivePair() -> {
                    append(currentWindow.first())
                    i++
                }
                else -> i += 2
            }
        }

        toString()
    }

    private fun String.isReactivePair() = length == 2 && this[0].reactsWith(this[1])

    private fun Char.reactsWith(other: Char): Boolean = when {
        isUpperCase() && other.isUpperCase() -> false
        isLowerCase() && other.isLowerCase() -> false
        else -> equals(other = other, ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(Day5Part1.solve())
}