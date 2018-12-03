package day02.second

import common.inputFilenameForDay
import java.io.File

/**
 * [Day 2](https://adventofcode.com/2018/day/2) - Part 2
 *
 * Time complexity: `O(n^3)`
 */
fun findCommonIDLetters(): String {
    val boxIDs = File(inputFilenameForDay(2)).readLines()

    for (i in 0 until boxIDs.lastIndex) {
        for (j in (i + 1)..boxIDs.lastIndex) {
            val diffIndex = differAtOneIndex(boxIDs[i], boxIDs[j])
            if (diffIndex != null) {
                return boxIDs[i].filterIndexed { index, _ -> index != diffIndex }
            }
        }
    }

    error("No pair of boxIDs differing at only 1 char found")
}

/**
 * Compare two strings, and if the characters differ at exactly 1 index,
 * return that index. If the strings differ at 0 or > 1 index, return null.
 *
 * Assumes that s1 & s2 are the same length (as in problem input).
 */
internal fun differAtOneIndex(s1: String, s2: String): Int? {
    var diffIndex: Int? = null
    (s1 zip s2).forEachIndexed { i, (a, b) ->
        when {
            a != b && diffIndex != null -> return null
            a != b && diffIndex == null -> diffIndex = i
        }
    }

    diffIndex ?: return null    // return null if strings are the same

    return diffIndex
}


fun main(args: Array<String>) {
    println(findCommonIDLetters())
}