package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BoardTest {

    @Test
    fun `3x3 보드가 생성된다`() {
        val boardHeight = BoardHeight(3)
        val boardWidth = BoardWidth(3)
        val mines = listOf(1, 4, 7)
        val board = Board.createBoard(boardHeight, boardWidth, mines)

        assertThat(board.squares.size).isEqualTo(9)
    }

    @Test
    fun `3x3 보드에 지뢰 3개가 생성된다`() {
        val boardHeight = BoardHeight(3)
        val boardWidth = BoardWidth(3)
        val mines = listOf(1, 4, 7)
        val board = Board.createBoard(boardHeight, boardWidth, mines)

        assertThat(board.squares.count { it.type == SquareType.MINE }).isEqualTo(3)
    }

    @Test
    fun `3x3 보드 1,1에 지뢰를 배치한다`() {
        val initialSquares = listOf(
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE)
        )
        val board = Board(initialSquares)
        val updatedBoard = board.updateSquare(4, Square(SquareType.MINE))

        assertThat(updatedBoard.squares[4].type).isEqualTo(SquareType.MINE)
    }
}
