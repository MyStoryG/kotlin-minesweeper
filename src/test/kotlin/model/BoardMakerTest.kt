package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BoardMakerTest {
    @Test
    fun `입력 받은 높이, 너비와 일치하는 보드가 생성된다`() {
        val boardHeight = 5
        val boardWidth = 5
        val mineSize = 5
        val board = BoardMaker().run(
            BoardHeight(boardHeight),
            BoardWidth(boardWidth),
            MineMaker().run(BoardHeight(boardHeight), BoardWidth(boardWidth), MineSize(mineSize))
        )
        val actual = board.size
        val expected = boardHeight * boardWidth

        assertThat(actual).isEqualTo(expected)
    }
}
