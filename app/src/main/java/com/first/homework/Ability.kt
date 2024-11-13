package com.first.homework

data class Ability(
    val name: String,
    val effect: String,
    val power: Int
): Item {
    override fun addItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun useItem(): Any {
        TODO("Not yet implemented")
    }

    override fun use(): Unit {
        println("Использована способность: $name с эффектом: $effect и силой: $power")
    }
}
