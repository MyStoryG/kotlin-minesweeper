package view

import model.Square
import model.SquareType

object OutputView {
    private const val TILE = "C"
    private const val MINE = "*"

    fun showBoard(board: List<Square>, width: Int) {
        println("지뢰찾기 게임 시작")
        board.forEachIndexed { index, square ->
            if (square.type == SquareType.TILE) {
                print("$TILE ")
            }
            if (square.type == SquareType.MINE) {
                print("$MINE ")
            }
            adjustWidth(index, width)
        }
    }

    private fun adjustWidth(index: Int, width: Int) {
        if ((index + 1) % width == 0) {
            println()
        }
    }
}
