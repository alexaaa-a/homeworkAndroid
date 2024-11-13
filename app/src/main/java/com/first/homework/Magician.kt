package com.first.homework

class Magician(name: String, strength: Int, health: Int, mana: Int) : Hero(name, strength, health) {
    val mana: Int = 20

    override fun attack(addition: Int): Int {
        val blow = strength + addition + mana
        return blow
    }

    override fun giveInfo() {
        super.giveInfo()
        println("Еще один интересный факт обо мне: я маг!")
    }

    override fun restoreHealth(damage: Int, resources: Int) {
        val restore = health - damage + resources + mana
        var lastResourcesMana = mana + resources - damage

        if (lastResourcesMana < 0) {
            lastResourcesMana = 0
        }
        println("Текущее здоровье $name: $restore, оставшиеся ресурсы c маной: $lastResourcesMana")
    }

    fun restoreMana(): Unit {
        println("Ваша мана восстановлена!")
    }

    inner class MagicWand: Inventory() {
        override fun use() {
            println("Вы использовали магический жезл!")
        }
    }
}