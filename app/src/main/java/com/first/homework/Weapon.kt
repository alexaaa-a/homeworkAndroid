package com.first.homework

data class Weapon(
    val name: String,
    val damage: Int
) : Item {
    override fun addItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun useItem(): Any {
        TODO("Not yet implemented")
    }

    override fun use(): Unit {
        println("Использовано оружие: $name с уроном: $damage")
    }
}
