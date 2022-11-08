package com.example.mycoffee.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "basket")
data class BasketProduct(

    @PrimaryKey
    val id: Int,
    val count: Int,
    val name: String,
    val price: Int
)