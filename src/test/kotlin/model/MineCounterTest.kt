package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MineCounterTest {

    @Test
    fun `0,0 주변에 지뢰가 없다면 지뢰의 개수가 0이다`() {
        val height = 3
        val width = 3
        val squares = listOf(
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE)
        )
        val mineCounter = MineCounter()
        val updatedSquares = mineCounter.calculateMineCounts(height, width, squares)
        val expectedMineCounts = listOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

        assertThat(updatedSquares.map { it.mineCount }).isEqualTo(expectedMineCounts)
    }

    @Test
    fun `0,0에 주변에 지뢰가 1개 있다면 지뢰의 개수가 1이다`() {
        val height = 3
        val width = 3
        val squares = listOf(
            Square(SquareType.TILE), Square(SquareType.MINE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE)
        )
        val mineCounter = MineCounter()
        val updatedSquares = mineCounter.calculateMineCounts(height, width, squares)
        val expectedMineCounts = listOf(1, 0, 1, 1, 1, 1, 0, 0, 0)

        assertThat(updatedSquares.map { it.mineCount }).isEqualTo(expectedMineCounts)
    }

    @Test
    fun `0,1이 지뢰라면 해당 좌표의 타입은 MINE이다`() {
        val height = 3
        val width = 3
        val squares = listOf(
            Square(SquareType.TILE), Square(SquareType.MINE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE)
        )
        val mineCounter = MineCounter()
        val updatedSquares = mineCounter.calculateMineCounts(height, width, squares)

        assertThat(updatedSquares[1].type).isEqualTo(SquareType.MINE)
    }

    @Test
    fun `0,1이 지뢰라면 해당 좌표의 주변 지뢰의 개수는 0이다`() {
        val height = 3
        val width = 3
        val squares = listOf(
            Square(SquareType.TILE), Square(SquareType.MINE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE),
            Square(SquareType.TILE), Square(SquareType.TILE), Square(SquareType.TILE)
        )
        val mineCounter = MineCounter()
        val updatedSquares = mineCounter.calculateMineCounts(height, width, squares)
        val expectedMineCounts = listOf(1, 0, 1, 1, 1, 1, 0, 0, 0)

        assertThat(updatedSquares.map { it.mineCount }).isEqualTo(expectedMineCounts)
    }
}
