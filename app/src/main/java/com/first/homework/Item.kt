package com.first.homework

interface Item {
    fun addItem(item: Item): Unit
    fun useItem(): Any
    fun use(): Unit
}