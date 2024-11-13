package com.first.homework

class Battle(val hero1: Hero, val hero2: Hero) {

    fun start(): BattleResult {
        val damageToHero2 = hero1.attack(10).also { println("${hero1.name} атаковал ${hero2.name} на $it урона!") }
        hero2.restoreHealth(damageToHero2, 5)

        if (hero2.health <= 0) {
            return BattleResult.Victory(hero1)
        }

        val damageToHero1 = hero2.attack(15).also { println("${hero2.name} атаковал ${hero1.name} на $it урона!") }
        hero1.restoreHealth(damageToHero1, 3)

        return when {
            hero1.health <= 0 && hero2.health <= 0 -> BattleResult.Draw
            hero1.health <= 0 -> BattleResult.Defeat(hero1)
            hero2.health <= 0 -> BattleResult.Defeat(hero2)
            else -> throw IllegalStateException("Битва еще идет!")
        }
    }
}