package model

data class Square(val type: SquareType = SquareType.TILE, val mineCount: Int = 0) {
    fun withMineCount(mineCount: Int): Square {
        return this.copy(mineCount = mineCount)
    }
}
