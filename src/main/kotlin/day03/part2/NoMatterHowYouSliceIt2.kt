package day03.part2

import common.inputFilenameForDay
import day03.Claim
import day03.Rectangle
import java.io.File

const val FABRIC_LENGTH = 1000
private val DAY_3_INPUT_FILENAME = inputFilenameForDay(3)

/**
 * [Day 3, Part 2](https://adventofcode.com/2018/day/3#part2)
 */
object Day3Part2 {
    fun solveProblem(): Int {
        return findNonOverlappingClaimID(FABRIC_LENGTH, readClaims())
    }

    internal fun findNonOverlappingClaimID(fabricLength: Int, claims: List<Claim>): Int {
        val rectangles = claims.map { it.rectangle }
        val markedFabric = markFabric(fabricLength, rectangles)

        (claims zip rectangles).forEach { (claim, r) ->
            if (isNonOverlapping(markedFabric, r)) {
                return claim.id
            }
        }

        error("No non-overlapping claims found")
    }

    /** Marks the fabric grid so that the value at i, j is the number of claims that use that overlap there */
    private fun markFabric(fabricLength: Int, rectangles: List<Rectangle>): Array<IntArray> {
        val fabric: Array<IntArray> = Array(fabricLength) { IntArray(fabricLength) }

        for (r in rectangles) {
            for (i in r.xIndices) {
                for (j in r.yIndices) {
                    fabric[i][j]++
                }
            }
        }

        return fabric
    }

    /**
     * Check if the given rectangle is used by only 1 claim.
     */
    private fun isNonOverlapping(markedFabric: Array<IntArray>, rectangle: Rectangle): Boolean {
        for (i in rectangle.xIndices) {
            for (j in rectangle.yIndices) {
                if (markedFabric[i][j] != 1) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * Read each encoded claim from the input file and convert each to a [Claim].
     */
    private fun readClaims(): List<Claim> = File(DAY_3_INPUT_FILENAME).readLines()
        .map { Claim.from(encodedClaim = it) }
}

fun main(args: Array<String>) {
    println(Day3Part2.solveProblem())
}