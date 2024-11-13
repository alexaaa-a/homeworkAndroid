package com.first.homework

interface Character {
    fun attack(addition: Int): Int
    fun restoreHealth(damage: Int, resources: Int): Unit
    fun talk(): Unit
    fun giveInfo(): Unit
}