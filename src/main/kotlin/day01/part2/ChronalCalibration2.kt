package day01.part2

import common.inputFilenameForDay
import java.io.File


private val DAY_1_INPUT_FILENAME = inputFilenameForDay(1)

/**
 * [Day 1, Part 2](https://adventofcode.com/2018/day/1#part2)
 */
object Day1Part2 {
    fun firstRepeatedFrequency(inputFilename: String): Int? {
        val freqChanges = File(inputFilename).useLines { lines ->
            lines.map { it.toInt() }.toList()
        }
        return findFirstRepeatedFrequency(freqChanges)
    }

    internal fun findFirstRepeatedFrequency(freqChanges: List<Int>): Int? {
        val distinctFreqs = hashSetOf(0)
        var currentFreq = 0

        val repeatingChanges: Sequence<Int> = freqChanges.asSequence().repeating()

        repeatingChanges.forEach { freqChange ->
            currentFreq += freqChange

            if (currentFreq in distinctFreqs) {
                return currentFreq
            }

            distinctFreqs += currentFreq
        }

        error("Something went wrong, this line should never be reached.")
    }
}

/**
 * Generate an infinitely repeating sequence.
 */
fun <T> Sequence<T>.repeating(): Sequence<T> = sequence {
    while (true) {
        yieldAll(this@repeating)
    }
}

fun main(args: Array<String>) {
    println(Day1Part2.firstRepeatedFrequency(DAY_1_INPUT_FILENAME))   // 241
}