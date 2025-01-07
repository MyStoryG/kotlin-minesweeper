package model

import kotlin.collections.mapNotNull

class BoardMaker {
    fun run(boardHeight: BoardHeight, boardWidth: BoardWidth, mines: List<Int>): List<Square> {
        val board = MutableList(calculateBoardSize(boardHeight, boardWidth)) { Square(SquareType.TILE) }
        mines.forEach { mine ->
            board[mine] = Square(SquareType.MINE)
        }
        calculateMineCounts(board, boardHeight.height, boardWidth.width)
        return board
    }

    private fun calculateBoardSize(boardHeight: BoardHeight, boardWidth: BoardWidth): Int {
        return boardHeight.height * boardWidth.width
    }

    private fun calculateMineCounts(board: MutableList<Square>, height: Int, width: Int) {
        for (row in 0 until height) {
            for (col in 0 until width) {
                val index = row * width + col
                if (isMine(board[index])) continue
                val mineCount = countMinesAround(board, row, col, height, width)
                board[index].mineCount = mineCount
            }
        }
    }

    private fun isMine(square: Square): Boolean {
        return square.type == SquareType.MINE
    }

    private fun countMinesAround(
        board: MutableList<Square>,
        row: Int,
        col: Int,
        height: Int,
        width: Int
    ): Int {
        val directions = listOf(
            Direction(-1, -1), Direction(-1, 0), Direction(-1, 1),
            Direction(0, -1), Direction(0, 1),
            Direction(1, -1), Direction(1, 0), Direction(1, 1)
        )
        return directions.mapNotNull { direction ->
            val newRow = row + direction.row
            val newCol = col + direction.col
            var mineCount = 0
            if (isValidPosition(newRow, newCol, height, width)) {
                val neighborIndex = newRow * width + newCol
                if (isMine(board[neighborIndex])) mineCount = 1
                return@mapNotNull mineCount
            }
            null
        }.sum()
    }

    private fun isValidPosition(row: Int, col: Int, height: Int, width: Int): Boolean {
        return row in 0 until height && col in 0 until width
    }

}
