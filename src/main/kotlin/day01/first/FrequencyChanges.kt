package day01.first

import common.INPUTS_DIR
import java.io.File

const val INPUT_FILE_DAY_1A = "$INPUTS_DIR/day_01a_input.txt"

/**
 * [Day 1](https://adventofcode.com/2018/day/1)
 */
fun findResultingFrequency(inputFilename: String): Int = File(inputFilename)
    .useLines { lines ->
        lines.sumBy { it.toInt() }
    }

fun main(args: Array<String>) {
    println(findResultingFrequency(INPUT_FILE_DAY_1A))
}