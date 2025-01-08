package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MineTest {
    @Test
    fun `지뢰가 5개 생성된다`() {
        val boardHeight = BoardHeight(5)
        val boardWidth = BoardWidth(5)
        val mineSize = MineSize(5)
        val mines = Mine.generateMines(boardHeight, boardWidth, mineSize)

        assertThat(mines.toSet().size).isEqualTo(mineSize.value)
    }
}
