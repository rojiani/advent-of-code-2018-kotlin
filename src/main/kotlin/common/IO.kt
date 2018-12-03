package common

const val INPUTS_DIR = "src/main/resources/input"

/**
 * Return the filename of the input for a given day.
 */
fun inputFilenameForDay(day: Int): String {
    require(day in 1..25) { "Invalid day - must be in range [1, 25]" }

    val paddedDay = day.toString().padStart(2, '0')
    return "$INPUTS_DIR/day_${paddedDay}_input.txt"
}