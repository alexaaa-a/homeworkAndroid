package com.first.homework

class Knight(name: String, strength: Int, health: Int, protection: Int): Hero(name, strength, health) {
    var protection = 30

    override fun restoreHealth(damage: Int, resources: Int): Unit {
        val restore = health - damage + resources + protection
        var lastResources = protection + resources - damage

        if (lastResources < 0) {
            lastResources = 0
        }
        println("Текущее здоровье $name: $restore, оставшиеся ресурсы: $lastResources")
    }

    inner class Sword: Inventory() {
        override fun use() {
            println("Вы использовали меч!")
        }
    }
}