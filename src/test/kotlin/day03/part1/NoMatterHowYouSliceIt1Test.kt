package day03.part1

import day03.first.Day3Part1
import org.junit.Assert.assertEquals
import org.junit.Test

class NoMatterHowYouSliceIt1Test {
    @Test
    fun solveProblem() {
        assertEquals(
            104126,
            Day3Part1.solveProblem()
        )
    }

    @Test
    fun areaOfDoublyClaimedFabric() {
        val claims = listOf(
            "#1 @ 1,3: 4x4",
            "#2 @ 3,1: 4x4",
            "#3 @ 5,5: 2x2"
        )

        val rectangles = claims.map { encodedClaim ->
            Claim.from(encodedClaim).rectangle
        }

        assertEquals(
            4,
            Day3Part1.areaOfDoublyClaimedFabric(
                fabricLength = 8,
                rectangles = rectangles
            )
        )
    }
}