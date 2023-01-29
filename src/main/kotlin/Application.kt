import model.BoardHeight
import model.BoardMaker
import model.BoardWidth
import model.MineMaker
import model.MineSize
import view.InputView
import view.OutputView

fun main() {
    val boardHeight = BoardHeight(InputView.getHeight())
    val boardWidth = BoardWidth(InputView.getWidth())
    val mineSize = MineSize(InputView.getMineNumber())
    val boardMaker = BoardMaker()
    val board = boardMaker.run(boardHeight, boardWidth, MineMaker().run(boardHeight, boardWidth, mineSize))
    OutputView.showBoard(board, boardWidth.width)
}
