package com.first.homework

sealed class BattleResult {
    data class Victory(val hero: Hero) : BattleResult()
    data class Defeat(val hero: Hero) : BattleResult()
    object Draw : BattleResult()
}