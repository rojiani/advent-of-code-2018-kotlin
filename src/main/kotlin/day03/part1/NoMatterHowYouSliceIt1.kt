package day03.first

import common.inputFilenameForDay
import day03.part1.Claim
import day03.part1.Rectangle
import java.io.File

const val FABRIC_LENGTH = 1000
private val DAY_3_INPUT_FILENAME = inputFilenameForDay(3)

/**
 * [Day 3, Part 1](https://adventofcode.com/2018/day/3)
 */
object Day3Part1 {

    fun solveProblem(): Int {
        val claims: List<Claim> = readClaims()
        val rectangles = claims.map { it.rectangle }
        return areaOfDoublyClaimedFabric(FABRIC_LENGTH, rectangles)
    }

    internal fun areaOfDoublyClaimedFabric(fabricLength: Int, rectangles: List<Rectangle>): Int {
        val fabric: Array<IntArray> = Array(fabricLength) { IntArray(fabricLength) }

        for (r in rectangles) {
            for (i in r.xIndices) {
                for (j in r.yIndices) {
                    fabric[i][j]++
                }
            }
        }

        var markedIn2OrMore = 0
        for (i in fabric.indices) {
            for (j in fabric[i].indices) {
                if (fabric[i][j] > 1) markedIn2OrMore++
            }
        }

        return markedIn2OrMore
    }

    /**
     * Read each encoded claim from the input file and convert each to a [Claim].
     */
    private fun readClaims(): List<Claim> = File(DAY_3_INPUT_FILENAME).readLines()
        .map { Claim.from(encodedClaim = it) }
}

fun main(args: Array<String>) {
    println(Day3Part1.solveProblem())
}