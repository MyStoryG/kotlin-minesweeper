package model

class BoardMaker {
    fun run(boardHeight: BoardHeight, boardWidth: BoardWidth, mines: List<Int>): List<Square> {
        val board = MutableList(calculateBoardSize(boardHeight, boardWidth)) { Square(SquareType.TILE) }
        mines.forEach { mine ->
            board[mine] = Square(SquareType.MINE)
        }
        return board
    }

    private fun calculateBoardSize(boardHeight: BoardHeight, boardWidth: BoardWidth): Int {
        return boardHeight.height * boardWidth.width
    }
}
