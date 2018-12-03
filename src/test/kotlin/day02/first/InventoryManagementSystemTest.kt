package day02.first

import org.junit.Test

import org.junit.Assert.*

class InventoryManagementSystemTest {

    @Test
    fun `test - calculateChecksum`() {
        assertEquals(
            12,
            calculateChecksum(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))
        )
    }
}