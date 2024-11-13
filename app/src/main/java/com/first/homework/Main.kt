package com.first.homework

fun main() {
    val knight = Knight(name = "Сэр Уильям", health = 100, strength = 20, protection = 5)
    val magician = Magician(name = "Николас", health = 80, strength = 15, mana = 30)

    val sword = Weapon(name = "Меч", damage = 25).apply {
        knight.getInventory().addItem(this)
    }

    val fireball = Ability(name = "Огненный шар", effect = "обжигать", power = 40).apply {
        magician.getInventory().addItem(this)
    }

    val battle = Battle(knight, magician)

    when (val result = battle.start()) {
        is BattleResult.Victory -> println("${result.hero.name} победил!")
        is BattleResult.Defeat -> println("${result.hero.name} проиграл.")
        BattleResult.Draw -> println("Ничья!")
    }

    knight.levelUp()
    println("${knight.name} прокачался! Новое здоровье: ${knight.health}, новая сила: ${knight.strength}")

}