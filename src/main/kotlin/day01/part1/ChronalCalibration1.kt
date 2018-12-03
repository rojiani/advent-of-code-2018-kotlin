package day01.part1

import common.inputFilenameForDay
import java.io.File

private val DAY_1_INPUT_FILENAME = inputFilenameForDay(1)

/**
 * [Day 1](https://adventofcode.com/2018/day/1) - Part 1
 */
fun findResultingFrequency(inputFilename: String): Int = File(inputFilename)
    .useLines { lines ->
        lines.sumBy { it.toInt() }
    }

fun main(args: Array<String>) {
    println(findResultingFrequency(DAY_1_INPUT_FILENAME))   // 592
}