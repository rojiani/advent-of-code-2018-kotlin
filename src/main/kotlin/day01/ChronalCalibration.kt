package day01

import common.INPUTS_DIR
import java.io.File

const val INPUT_FILE_DAY_1 = "$INPUTS_DIR/day_01_input.txt"

/**
 * [Day 1](https://adventofcode.com/2018/day/1) - part 1
 */
fun findResultingFrequency(inputFilename: String): Int = File(inputFilename)
    .useLines { lines ->
        lines.sumBy { it.toInt() }
    }

/**
 * [Day 1](https://adventofcode.com/2018/day/1) - part 2
 */
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

    return null     /* should never reach this line, but return type needed. */
}

fun <T> Sequence<T>.repeating(): Sequence<T> = sequence {
    while (true) {
        yieldAll(this@repeating)
    }
}

/**
 * Answers:
 * Part 1 => 592
 * Part 2 => 241
 */
fun main(args: Array<String>) {
    println(findResultingFrequency(INPUT_FILE_DAY_1))
    println(firstRepeatedFrequency(INPUT_FILE_DAY_1))
}