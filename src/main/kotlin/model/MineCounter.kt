package model

class MineCounter {
    fun calculateMineCounts(height: Int, width: Int, squares: List<Square>): List<Square> {
        return squares.mapIndexed { index, square ->
            val row = index / width
            val col = index % width
            if (isTile(square)) {
                val mineCount = countMinesAround(row, col, height, width, squares)
                square.withMineCount(mineCount)
            } else {
                square
            }
        }
    }

    private fun countMinesAround(row: Int, col: Int, height: Int, width: Int, squares: List<Square>): Int {
        return MINE_DETECTION_DIRECTION.mapNotNull { direction ->
            val newRow = row + direction.row
            val newCol = col + direction.col
            var mineCount = 0
            if (isValidPosition(newRow, newCol, height, width)) {
                val neighborIndex = newRow * width + newCol
                if (isMine(squares[neighborIndex])) mineCount = 1
                return@mapNotNull mineCount
            }
            null
        }.sum()
    }

    private fun isValidPosition(row: Int, col: Int, height: Int, width: Int): Boolean {
        return row in 0 until height && col in 0 until width
    }

    private fun isMine(square: Square): Boolean {
        return square.type == SquareType.MINE
    }

    private fun isTile(square: Square): Boolean {
        return square.type == SquareType.TILE
    }

    companion object {
        private val MINE_DETECTION_DIRECTION = listOf(
            Direction(-1, -1), Direction(-1, 0), Direction(-1, 1),
            Direction(0, -1), Direction(0, 1),
            Direction(1, -1), Direction(1, 0), Direction(1, 1)
        )
    }
}
