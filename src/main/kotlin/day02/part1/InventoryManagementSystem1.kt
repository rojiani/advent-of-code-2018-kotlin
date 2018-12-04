package day02.part1

import common.inputFilenameForDay
import java.io.File

private val DAY_2_INPUT_FILENAME = inputFilenameForDay(2)

/**
 * [Day 2, Part 1](https://adventofcode.com/2018/day/2)
 */
object Day2Part1 {
    fun calculateChecksumForInput(inputFilename: String): Int = calculateChecksum(File(inputFilename).readLines())

    internal fun calculateChecksum(boxIDs: List<String>): Int {
        val counts = boxIDs.fold(Pair(0, 0)) { acc, id ->
            val (has2x, has3x) = id.has2xAnd3xLetters()
            Pair(
                acc.first + (if (has2x) 1 else 0),
                acc.second + (if (has3x) 1 else 0)
            )

        }
        return counts.first * counts.second
    }

    /** Return a pair of whether the String contains a letter that appears 2 and 3 times. */
    private fun String.has2xAnd3xLetters(): Pair<Boolean, Boolean> {
        val letterCounts = groupingBy { it }.eachCount()
        return Pair(2 in letterCounts.values, 3 in letterCounts.values)
    }
}

fun main(args: Array<String>) {
    println(Day2Part1.calculateChecksumForInput(DAY_2_INPUT_FILENAME))
}