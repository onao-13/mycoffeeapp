package com.example.mycoffee.model

sealed class OrderStatus(
    val status: String
) {
    object Paid : OrderStatus("paid")
    object Cooking : OrderStatus("cooking")
    object Cooked : OrderStatus("cooked")
    object Given : OrderStatus("given")
}
