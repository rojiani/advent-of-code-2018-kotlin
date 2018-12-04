package day02.second

import org.junit.Test

import org.junit.Assert.*

class InventoryManagementSystem2Test {

    @Test
    fun findCommonIDLetters() {
        assertEquals("kqzxdenujwcstybmgvyiofrrd", Day2Part2.findCommonIDLetters())
    }

    @Test
    fun differAtOneIndex() {
        assertNull(Day2Part2.differAtOneIndex("abcde", "axcye"))
        assertNull(Day2Part2.differAtOneIndex("abcde", "fghij"))
        assertNull(Day2Part2.differAtOneIndex("a", "a"))
        assertNull(Day2Part2.differAtOneIndex("abc", "ade"))

        assertEquals(0, Day2Part2.differAtOneIndex("a", "b"))
        assertEquals(1, Day2Part2.differAtOneIndex("aa", "ab"))
        assertEquals(1, Day2Part2.differAtOneIndex("aac", "abc"))
        assertEquals(1, Day2Part2.differAtOneIndex("abcde", "axcde"))
        assertEquals(2, Day2Part2.differAtOneIndex("fghij", "fguij"))
    }
}