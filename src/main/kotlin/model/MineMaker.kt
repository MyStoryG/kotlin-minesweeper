package model

class MineMaker {
    fun run(boardHeight: BoardHeight, boardWidth: BoardWidth, mineSize: MineSize): List<Int> {
        return (0 until (boardHeight.height * boardWidth.width)).shuffled().subList(0, mineSize.value)
    }
}
