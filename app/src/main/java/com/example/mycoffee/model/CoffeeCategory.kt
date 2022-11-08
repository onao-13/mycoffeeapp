package com.example.mycoffee.model

sealed class CoffeeCategory(
    val category: String
) {
    object Espresso: CoffeeCategory("espresso")
    object Americano: CoffeeCategory("americano")
    object Lungo: CoffeeCategory("lungo")
    object Ristretto: CoffeeCategory("ristretto")
    object Cappuccino: CoffeeCategory("cappuccino")
    object Latte: CoffeeCategory("latte")
    object Raf: CoffeeCategory("raf")
    object Macchiato: CoffeeCategory("macchiato")
    object AffogatoAndGlasse: CoffeeCategory("affogato and glasse")
}
