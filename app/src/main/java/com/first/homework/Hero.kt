package com.first.homework

open class Hero(name: String, strength: Int, health: Int): Character {
    val name: String = ""
    var strength: Int = 50
    var health: Int = 100

    override fun attack(addition: Int): Int {
        val blow = strength + addition
        return blow
    }

    override fun restoreHealth(damage: Int, resources: Int): Unit {
        val restore = health - damage + resources
        var lastResources = resources - damage

        if (lastResources < 0) {
            lastResources = 0
        }
        println("Текущее здоровье $name: $restore, оставшиеся ресурсы: $lastResources")
    }

    override fun talk(): Unit {
        println("Привет, игрок! Меня зовут $name. Давай спасем этот мир!")
    }

    override fun giveInfo(): Unit {
        println("Имя: $name, сила: $strength, здоровье: $health")
    }

    open inner class Inventory: Item {
        private val items = mutableListOf<Item>()

        override fun addItem(item: Item) {
            items.add(item)
        }

        override fun useItem(): Any {
            return if (items.isNotEmpty()) {
                items.first().use().also { items.removeAt(0) }
            } else {
                "Нечего использовать"
            }
        }

        override fun use() {
            TODO("Not yet implemented")
        }

    }

    fun getInventory() = Inventory()
}

fun Hero.levelUp() {
    health = (health + 10).coerceAtMost(GameConfig.maxHealth)
    strength += 2
}

val Hero.isAlive: Boolean
    get() = health > 0