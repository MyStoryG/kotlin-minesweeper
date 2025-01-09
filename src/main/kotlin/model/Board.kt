package model

class Board(val squares: List<Square>) {
    fun updateSquare(index: Int, square: Square): Board {
        val updatedSquares = squares.toMutableList()
        updatedSquares[index] = square
        return Board(updatedSquares)
    }

    companion object {
        fun createBoard(boardHeight: BoardHeight, boardWidth: BoardWidth, mines: List<Int>): Board {
            val boardSize = boardHeight.height * boardWidth.width
            val initialSquares = List(boardSize) { Square(SquareType.TILE) }
            var board = Board(initialSquares)

            mines.forEach { index ->
                board = board.updateSquare(index, Square(SquareType.MINE))
            }

            val updatedSquares = MineCounter().calculateMineCounts(boardHeight.height, boardWidth.width, board.squares)
            return Board(updatedSquares)
        }
    }
}
