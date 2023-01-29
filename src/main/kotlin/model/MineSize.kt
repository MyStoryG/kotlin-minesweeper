package model

@JvmInline
value class MineSize(val value: Int) {
    init {
        require(value > 0) { "지뢰 개수는 0보다 커야 합니다." }
    }
}
