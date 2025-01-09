import model.Board
import model.BoardHeight
import model.BoardWidth
import model.Mine
import model.MineSize
import view.InputView
import view.OutputView

fun main() {
    val boardHeight = BoardHeight(InputView.getHeight())
    val boardWidth = BoardWidth(InputView.getWidth())
    val mineSize = MineSize(InputView.getMineNumber())
    val mines = Mine.generateMines(boardHeight, boardWidth, mineSize)
    val board = Board.createBoard(boardHeight, boardWidth, mines)
    OutputView.showBoard(board.squares, boardWidth.width)
}
