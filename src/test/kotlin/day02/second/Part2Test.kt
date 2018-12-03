package day02.second

import org.junit.Test

import org.junit.Assert.*

class Part2Test {

    @Test
    fun `test findCommonIDLetters`() {
        assertEquals("kqzxdenujwcstybmgvyiofrrd", findCommonIDLetters())
    }

    @Test
    fun `test differAtOneIndex`() {
        assertNull(differAtOneIndex("abcde", "axcye"))
        assertNull(differAtOneIndex("abcde", "fghij"))
        assertNull(differAtOneIndex("a", "a"))
        assertNull(differAtOneIndex("abc", "ade"))

        assertEquals(0, differAtOneIndex("a", "b"))
        assertEquals(1, differAtOneIndex("aa", "ab"))
        assertEquals(1, differAtOneIndex("aac", "abc"))
        assertEquals(1, differAtOneIndex("abcde", "axcde"))
        assertEquals(2, differAtOneIndex("fghij", "fguij"))
    }
}