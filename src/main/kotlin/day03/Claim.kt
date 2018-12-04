package day03

/** An elven claim for a portion of the chimney-squeeze fabric. */
data class Claim(
    val id: Int,
    val leftMargin: Int,
    val topMargin: Int,
    val width: Int,
    val height: Int
) {
    /**
     * Get the [Rectangle] for the claim on the fabric coordinate plane.
     * The top-left corner of the fabric is (0, 0), and the bottom-right corner
     * of the fabric is (fabric.length, fabric.length).
     */
    val rectangle: Rectangle
        get() = Rectangle(
            topLeft = Point(leftMargin, topMargin),
            topRight = Point(leftMargin + width - 1, topMargin),
            bottomLeft = Point(leftMargin, topMargin + height - 1),
            bottomRight = Point(leftMargin + width - 1, topMargin + height - 1)
        )

    /**
     * Convert back to its encoded string form:
     * ```
     * Claim(
     *     id = 1,
     *     leftMargin = 829,
     *     topMargin = 837,
     *     width = 11,
     *     height = 22
     * ).encoded == "#1 @ 829,837: 11x22"
     * ```
     */
    val encoded: String
        get() = "#$id @ $leftMargin,$topMargin: ${width}x$height"

    companion object {
        /**
         * Static factory method for creating a [Claim] from its encoded string form.
         * @param encodedClaim The encoded string form of a claim, e.g., "#520 @ 279,538: 25x17"
         */
        fun from(encodedClaim: String): Claim {
            val (id, left, top, w, h) = encodedClaim.split("#", " ", "@", ",", ":", "x")
                .filter { it.isNotBlank() }
                .map { it.toInt() }
            
            return Claim(id, left, top, w, h)
        }
    }
}