package day03.part2

import day03.Claim
import org.junit.Test

import org.junit.Assert.*

class NoMatterHowSliceIt2Test {

    @Test
    fun solveProblem() {
        assertEquals(695, Day3Part2.solveProblem())
    }

    @Test
    fun findNonOverlappingClaimID() {
        val claims = listOf(
            "#1 @ 1,3: 4x4",
            "#2 @ 3,1: 4x4",
            "#3 @ 5,5: 2x2"
        ).map { Claim.from(it) }

        assertEquals(3, Day3Part2.findNonOverlappingClaimID(8, claims))
    }
}