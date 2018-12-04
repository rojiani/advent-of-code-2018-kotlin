package day03.part1

import org.junit.Test

import org.junit.Assert.*

class RectangleTest {

    @Test
    fun getArea() {
        assertEquals(1, Rectangle(Point(0, 0), Point(1, 1)).area)
        assertEquals(4, Rectangle(Point(0, 0), Point(2, 2)).area)
        assertEquals(16, Rectangle(Point(-2, -2), Point(2, 2)).area)
        assertEquals(12, Rectangle(bottomLeft = Point(944, 740), topRight = Point(947, 736)).area)
        assertEquals(841, Rectangle(bottomLeft = Point(793, 705), topRight = Point(822, 676)).area)
    }

}