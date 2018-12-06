package day05.part2

import day05.part1.Day5Part1

/**
 * [Day 5, Part 2](https://adventofcode.com/2018/day/5#part2)
 */
object Day5Part2 {

    fun solve(): Int {
        val input = Day5Part1.readInput()

        return ('a'..'z').map { unit ->
            val withoutUnit = input.filterNot { it.toLowerCase() == unit }
            Day5Part1.alchemicallyReduce(withoutUnit).length
        }.min()!!
    }

}

fun main(args: Array<String>) {
    println(Day5Part2.solve())
}