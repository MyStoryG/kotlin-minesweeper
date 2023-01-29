package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MineMakerTest {
    @Test
    fun `입력 받은 개수의 지뢰에 대한 임의의 위치를 선정한다`() {
        val boardHeight = 5
        val boardWidth = 5
        val mineSize = 5
        val mines = MineMaker().run(BoardHeight(boardHeight), BoardWidth(boardWidth), MineSize(mineSize))

        assertThat(mines.toSet().size).isEqualTo(mineSize)
    }
}
