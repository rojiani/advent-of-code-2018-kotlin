package day03.part1

import common.inputFilenameForDay
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class ClaimTest {

    @Test
    fun encoded() {
        assertEquals(
            "#520 @ 279,538: 25x17",
            Claim(id = 520, leftMargin = 279, topMargin = 538, width = 25, height = 17).encoded
        )
    }

    @Test
    fun from() {
        assertEquals(
            Claim(id = 520, leftMargin = 279, topMargin = 538, width = 25, height = 17),
            Claim.from("#520 @ 279,538: 25x17")
        )
    }

    @Test
    fun parseAllClaims() {
        val encodedClaims = File(inputFilenameForDay(3)).readLines()
        encodedClaims.forEach { encoded ->
            assertEquals(encoded, Claim.from(encoded).encoded)
        }
    }


}