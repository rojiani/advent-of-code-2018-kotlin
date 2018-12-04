package day03.part1

import kotlin.math.abs

data class Rectangle(
    val bottomLeft: Point,
    val topRight: Point,
    val topLeft: Point = Point(bottomLeft.x, topRight.y),
    val bottomRight: Point = Point(topRight.x, bottomLeft.y)
) {
    val area: Int
        get() = abs(topRight.x - topLeft.x) * abs(bottomRight.y - topRight.y)

    val xIndices: IntRange
        get() = topLeft.x..topRight.x

    val yIndices: IntRange
        get() = topLeft.y..bottomLeft.y
}

/** A 2D `(x, y)` point in the Cartesian coordinate system. */
data class Point(val x: Int, val y: Int)
